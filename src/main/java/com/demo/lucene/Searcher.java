package com.demo.lucene;

import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * Lucene: 查询类
 * @author caish
 * @date 2018年8月7日 
 */
public class Searcher {

	/** 默认索引文件夹 */
	public static final String INDEX_DIR = "F:\\text\\lucene";
	private static IndexReader indexReader;
	
	public static void search(String indexDir, String keyWord) throws Exception {
		// 获取索引文件
		Directory directory = FSDirectory.open(Paths.get(indexDir));
		indexReader = DirectoryReader.open(directory);
		IndexSearcher indexSearch = new IndexSearcher(indexReader);
		// IndexSearcher indexSearch = getIndexSearcher(directory);
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser queryParser = new QueryParser("centents", analyzer);
		Query query = queryParser.parse(keyWord);
		TopDocs result = indexSearch.search(query, 10);
		ScoreDoc[] scoreDocs = result.scoreDocs;
		System.out.println("共检索到 " + result.totalHits + " 条结果,分别为:");
		for (ScoreDoc scoreDoc : scoreDocs) {
			Document doc = indexSearch.doc(scoreDoc.doc);
			// 索引文件存的什么名字 这里就以什么名字取
			System.out.println("文件名:" + doc.get("fileName") + "; 路径: " + doc.get("fullPath"));
		}
		indexReader.close();
	}
	
	/**
	 * 重用一些旧的 IndexReader
	 * @return
	 */
	public static IndexSearcher getIndexSearcher(Directory directory) {
		try {
			if (indexReader == null) {
				indexReader = DirectoryReader.open(directory);
			} else {
				// 如果 IndexReader 不为空，就使用 DirectoryReader 打开一个索引变更过的 IndexReader
				// 此时要记得把旧的索引对象关闭
				// 参考资料：Lucene系列-近实时搜索(1)
				// http://blog.csdn.net/whuqin/article/details/42922813
				IndexReader newReader = DirectoryReader.openIfChanged((DirectoryReader) indexReader);
				if (newReader != null) {
					indexReader.close();
					indexReader = newReader;
				}
			}
			return new IndexSearcher(indexReader);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		try {
			search(INDEX_DIR, "document.getElementById");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
