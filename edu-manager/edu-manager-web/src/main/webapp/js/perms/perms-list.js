/**
 * 
 */
/**
 * 
 */
var perms = PERMS = {
		formatDateTime : function(val,row){
			var now = new Date(val);
	    	return now.format("yyyy-MM-dd hh:mm:ss");
		},
		formatPermsType : function(val,row){
			if(val==0){
				return "菜单栏";
			}else{
				return "具体权限";
			}
		},
		listToolbar:[
			{
				text:'新增权限',
				iconCls:'icon-add',
				handler:function(){
					
						layer.open({
							  type: 2,
							  area: ['800px', '640px'],
							  fixed: false, //不固定
							  maxmin: true,
							  content: 'page/permission/page-add'
						});
					
					
				}
			},
			{
				text:'权限删除',
				iconCls:'icon-cancel',
				handler:function(){
					layer.confirm('是否删除该权限及其子权限？',
						function(){
						  layer.msg('删除成功', {icon: 1});
						});
				}
			},
		]
}