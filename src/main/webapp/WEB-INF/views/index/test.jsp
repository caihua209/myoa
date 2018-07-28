<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/commons/base.jsp"%>
<!DOCTYPE HTML>  
<html lang="zh-CN">  
<head>  
    <meta charset="UTF-8">  
    <title>Bootstrap 3 的多级下拉菜单示例</title>  
    <link rel="stylesheet" href="${ctxPath}/plugins/bootstrap-3.37/css/bootstrap.min.css"/>  
    <script type="text/javascript" src="${ctxPath}/plugins/jquery/jquery-1.12.4.min.js"></script>  
    <script type="text/javascript" src="${ctxPath}/plugins/bootstrap-3.37/js/bootstrap.min.js"></script>  
    
    <style type="text/css">  
        .dropdown-submenu {  
            position: relative;  
        }  
        .dropdown-submenu > .dropdown-menu {  
            top: 0;  
            left: 100%;  
            margin-top: -6px;  
            margin-left: -1px;  
            -webkit-border-radius: 0 6px 6px 6px;  
            -moz-border-radius: 0 6px 6px;  
            border-radius: 0 6px 6px 6px;  
        }  
        .dropdown-submenu:hover > .dropdown-menu {  
            display: block;  
        }  
        .dropdown-submenu > a:after {  
            display: block;  
            content: " ";  
            float: right;  
            width: 0;  
            height: 0;  
            border-color: transparent;  
            border-style: solid;  
            border-width: 5px 0 5px 5px;  
            border-left-color: #ccc;  
            margin-top: 5px;  
            margin-right: -10px;  
        }  
        .dropdown-submenu:hover > a:after {  
            border-left-color: #fff;  
        }  
        .dropdown-submenu.pull-left {  
            float: none;  
        }  
        .dropdown-submenu.pull-left > .dropdown-menu {  
            left: -100%;  
            margin-left: 10px;  
            -webkit-border-radius: 6px 0 6px 6px;  
            -moz-border-radius: 6px 0 6px 6px;  
            border-radius: 6px 0 6px 6px;  
        }  
    </style>  
</head>  
<body>  
<div class="container">  
    <div class="row">  
        <h2>Bootstrap 3多级下拉菜单</h2>  
        <div class="dropdown" id="dropdown">  
            <a id="dLabel" role="button" data-toggle="dropdown" class="btn btn-primary" data-target="#" href="javascript:;">  
             	下拉多级菜单 <span class="caret"></span>  
            </a>  
            
        </div>  
    </div>  
</div>  
<script type="text/javascript">

	var initmenu = function(dropdown,menudata) {
		var dropdown = $(dropdown);
		function createNode(data) {
			var html ='<ul class="dropdown-menu">';
			for(var key in data) {
				if(data[key]["child"]) {
					html +='<li class="dropdown-submenu"><a href="'+data[key]["link"]+'" onclick="'+data[key]["click"]+'">'+data[key]["name"]+'</a>';
					html += createNode(data[key]["child"]);
				} else {
					html +='<li><a href="'+data[key]["link"]+'" onclick="'+data[key]["click"]+'">'+data[key]["name"]+'</a>';
				}
				dropdown.append('</li>');
			}
			html +='</ul>';
			return html;
		}
		var html = createNode(menudata);
		dropdown.append(html);
	}
	
    var menudata = {
		//name:"顶级菜单",
		"id1":{name:"一级菜单1",link:"link"},
		"id2":{name:"一级菜单2",link:"link"},
		"id3":{name:"一级菜单3",link:"link"},
		"id4":{
		   name:"一级菜单4",link:"link",
		   child: {
		    	"id5":{name:"二级菜单1",link:"link"},
		    	"id6":{name:"二级菜单2",link:"link"},
		    	"id7":
		    		{
			    		name:"二级菜单3",
			    		link:"link",
			    	    child:{
			    	    	"id8": {
			    	    		name:"三级菜单1",
					    		link:"link",
					    	    child:{
			    	    			"四级菜单":{name:"二级菜单2",link:"link"}
					    	    }
			    	    	}
			    	    }
		    		}
		    }
		}
	}
	initmenu("#dropdown",menudata);
</script>
</body>  
</html> 