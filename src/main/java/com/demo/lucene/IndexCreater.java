package com.demo.lucene;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * Lucene:索引创建类
 * @author caish
 * @date 2018年8月6日 
 */
public class IndexCreater {

	/** 写索引的实例到指定目录下 */
	private IndexWriter indexWriter;

	/**
	 * 构造方法:实例化IndexWriter
	 * @param indexDir 写索引到哪
	 * @throws Exception
	 */
	public IndexCreater(String indexDir) throws Exception {
		// 得到索引所在目录的路径
		Directory dir = FSDirectory.open(Paths.get(indexDir));
		// 实例化标准分析器
		Analyzer analyzer = new StandardAnalyzer();
		// Analyzer analyzer = new IKAnalyzer();
		IndexWriterConfig conf = new IndexWriterConfig(analyzer);
		indexWriter = new IndexWriter(dir, conf);
	}
	
	/**
	 * 关闭创建索引
	 * @throws IOException
	 */
	public void close() throws IOException {
		indexWriter.close();
	}
	
	/**
	 * 索引指定目录下的文件
	 * @param dataDir 需要写索引的文件目录
	 * @return
	 * @throws Exception 
	 */
	public int index(String dataDir) throws Exception {
		// 得到文件目录下的所有文件
		File[] files = new File(dataDir).listFiles();
		for (File file : files) {
			indexFile(file);
		}
		// 返回索引了多少个文件
		return indexWriter.numDocs();
	}

	/**
	 * 索引单个文件
	 * @param file
	 * @throws Exception 
	 */
	private void indexFile(File file) throws Exception {
		// 根据文件转为文档
		Document doc = getDocument(file);
		// 开始写入,就把文档写进了索引文件里去了；
		indexWriter.addDocument(doc);
	}

	private Document getDocument(File file) throws Exception {
		Document doc = new Document();
		// 把文件内容存索引文件里
		doc.add(new TextField("centents", new FileReader(file)));
		// 把文件名存索引文件里
		doc.add(new TextField("fileName", file.getName(), Field.Store.YES));
		// 把文件路径存索引文件里
		doc.add(new TextField("fullPath", file.getCanonicalPath(), Field.Store.YES));
		return doc;
	}
	
	public static void main(String[] args) {
		String indexDir = "F:\\text\\lucene";
		String dataDir = "F:\\text\\lucene\\data";
		IndexCreater indexCreater = null;
		int indexNum = 0;
		long startTime = System.currentTimeMillis();
		try {
			indexCreater = new IndexCreater(indexDir);
			indexNum = indexCreater.index(dataDir);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				indexCreater.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("共索引了:" + indexNum + " 个文件,一共用时: " + (endTime - startTime) + "毫秒");
	}
}
