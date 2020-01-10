/* post提交 */
function post(url,data){
	$.post(url,data,function(d){
		$.messager.alert('提示',d.msg);
		refresh();
	});
}

function isSelect(datagrid_id){
var rows = $("#"+datagrid_id).datagrid("getSelections");
	if(rows == ''){
		return false;
	}
	return true;
}		



/*获得选中的id*/
function getSelectIds(datagrid_id){
	var rows = $("#"+datagrid_id).datagrid("getSelections");
	var ids = '';
	for(i in rows){
		if(ids != '')
			ids+=','	
		ids+=rows[i].id
	}
	return ids;
}

/*打开一个弹窗*/
function openWindow(url,id,wid,hig,iframe_name){
	var title = document.activeElement.innerText;
	var content = '<iframe name="'+iframe_name+'" src="'+url+'" width="100%" height="99%" frameborder="0" ></iframe>';
	$('#'+id).dialog({
		title:title,
	    width:wid,
	    height:hig,
	    modal:true,
	    content:content
	});
}

function openWindow_noscroll(url,id,wid,hig,iframe_name){
	var title = document.activeElement.innerText;
	var content = '<iframe name="'+iframe_name+'" src="'+url+'" width="100%" height="99%" frameborder="0" scrolling="no"></iframe>';
	$('#'+id).dialog({
		title:title,
	    width:wid,
	    height:hig,
	    modal:true,
	    content:content
	});
}

/*刷新datagrid*/
function dg_refresh(id){
	$('#'+id).datagrid('reload'); 
	
}

function tg_refresh(id){
	$('#'+id).treegrid('reload'); 
}

/*关闭窗口*/
function close_window(id){
	$('#'+id).dialog('close');
}