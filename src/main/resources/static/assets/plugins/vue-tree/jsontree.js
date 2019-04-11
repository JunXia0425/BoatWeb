//将后台的json转成jsonTree格式
var jsonTree = function (data,config) {
    //1.声明了变量，拿到传参过来的值，注意这里拿到的是string类型，不是对应的值
    var id = config.id || 'id',
        pid = config.pid || 'pid',
        children = config.children || 'children';
        var idMap = [],
        newIdMap = [],
        jsonTree = [];
   /*2.v[id]==v[“id”]==v.id
      idMap数组的下标对应着id为下标的相应json数据
      a[1]对应着id为1的json数据，以此类推*/
    data.forEach(function(v){
      idMap[v[id]] = v;
    });
    //3拿到当前遍历的父元素id
  /*			根据父元素id，判断数组里是否存在这样一条数据
              存在，就判断父元素是否有子元素数组，若没有就添加一个children数组（传参过来的） 
              把当前元素添加父元素的children数组里
              不存在，就直接添加到jsonTree里*/
    data.forEach(function(v){
      var parent = idMap[v[pid]];
      //定义一个newIdMap
      delete v.parent;//删除{v}的parent和id
      //delete v.id;
      if(parent) {
        !parent[children] && (parent[children] = []);
        parent[children].push(v);
      } else {
        jsonTree.push(v);
      }
    });
    return jsonTree;
  };
  
  let data = {
    "status": 1,
    "state": "success",
    "msg": "ok",
    "referer": null,
    "result": [
        {
            "id": "1",
            "pid": null,
            "name": "关于我们",
            "url": "/connect us",
            "num": 1,
            "levels": 1,
            "tips": "联系",
            "enableStatus": 1,
            "createTime": "2019-04-10 16:10:46",
            "lastEditTime": "2019-04-10 16:10:46"
        },
        {
            "id": "2",
            "pid": "1",
            "name": "sads",
            "url": null,
            "num": null,
            "levels": null,
            "tips": null,
            "enableStatus": 1,
            "createTime": "2019-04-10 16:26:22",
            "lastEditTime": "2019-04-10 16:26:22"
        }
    ]
}  

