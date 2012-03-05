/* 
 * only for user_settings.jsp
 */
$(document).ready(function(){
    var cities = {
        "河北": ["唐山", "邯郸", "保定", "承德", "秦皇岛", "石家庄"],
        "山西":["太原", "大同", "阳泉", "长治", "晋城", "晋中", "运城", "临汾"],
        "内蒙":["呼和浩特", "呼伦贝尔", "包头", "乌海", "赤峰", "兴安盟"],
        "辽宁":["沈阳", "大连", "鞍山", "抚顺", "本溪", "丹东", "锦州", "阜新", "辽阳", "铁岭"],
        "吉林":["长春", "吉林", "四平", "辽源", "通化", "松原"],
        "黑龙江":["哈尔滨", "大兴安岭", "鸡西", "大庆", "黑河", "齐齐哈尔"],
        "江苏": ["南京", "无锡", "徐州", "常州", "苏州", "南通", "扬州", "镇江", "连云港"],
        "浙江": ["杭州", "宁波", "温州", "嘉兴", "绍兴", "金华", "衢州", "台州", "丽水"],
        "安徽": ["合肥", "芜湖", "蚌埠", "淮南", "淮北", "铜陵", "安庆", "黄山", "马鞍山"],
        "福建":["福州", "厦门", "莆田", "三明", "泉州"],
        "江西": ["南昌", "九江", "鹰潭", "赣州", "上饶", "景德镇"],
        "山东":["济南", "青岛", "烟台", "德州", "聊城", "滨州", "荷泽"],
        "河南":["郑州", "开封", "洛阳", "安阳", "许昌", "南阳", "周口", "驻马店", "三门峡"],
        "湖北":["武汉", "黄石", "宜昌", "荆门", "荆州", "黄冈", "咸宁", "恩施"],
        "湖南":["长沙", "湘潭", "岳阳", "常德", "益阳", "郴州", "湘西", "张家界"],
        "广东":["广州", "韶关", "深圳", "珠海", "汕头", "佛山", "江门", "湛江", "惠州", "东莞", "中山"],
        "广西":["南宁", "柳州", "桂林", "北海", "玉林"],
        "海南":["海口", "三亚", "海南沿革"],
        "四川":["成都", "泸州", "德阳", "绵阳", "乐山", "眉山", "宜宾", "攀枝花"],
        "贵州":["贵阳", "遵义", "安顺", "铜仁", "六盘水"],
        "云南":["昆明", "曲靖", "玉溪", "保山", "丽江", "大理"],
        "陕西":["西安", "铜川", "宝鸡", "咸阳", "延安", "汉中"],
        "甘肃":["兰州", "金昌", "白银", "天水", "嘉峪关"],
        "青海":["西宁", "海东", "海北", "黄南", "海南", "果洛", "玉树", "海西"],
        "宁夏":["银川", "吴忠", "固原", "中卫"],
        "新疆":["乌鲁木齐", "克拉玛依", "哈密", "伊犁", "吐鲁番"]
    };


    $("#province > option").click(function() {
        var option_string = "";
        for (var i in  cities[$(this).text()]) {
            option_string += "<option>" + cities[$(this).text()][i] + "</option>";
        }
        $("select#city").replaceWith("<select name='city' class='setting_sel' id='city'>" + option_string + "</select>");
    });
    $("#based_info_tab").click(function () {
        clicktab(this);
        $("#based_info_headtext").removeClass("mask");
        $("form#based_info_form").removeClass("mask");
    });
    $("#pw_info_tab").click(function () {
        clicktab(this);
        $("#pw_info_headtext").removeClass("mask");
        $("form#modify_pw_form").removeClass("mask");
    });
    $("#modify_photo_tab").click(function () {
        clicktab(this);
        $("#modify_photo_headtext").removeClass("mask");
        $("form#setting_photo_form").removeClass("mask");
    });

    $("#based_info_save").click(function(){
        $("form#based_info_form").submit();
    });

    $("#modify_pw_save").click(function(){
        $("form#modify_pw_form").submit();
    });

    $(".photo").click(function(){
        $("div.sp_160").attr("style", "background: url('pic/face/" + $(this).attr("id") + "160.png')");
        $("div.sp_160").attr("id", $(this).attr("id"));
        $("div.sp_75").attr("style", "background: url('pic/face/" + $(this).attr("id") + "75.png')");
        $("div.sp_75").attr("id", $(this).attr("id"));
        $("div.sp_45").attr("style", "background: url('pic/face/" + $(this).attr("id") + "45.png')");
        $("div.sp_45").attr("id", $(this).attr("id"));
        $("div.sp_25").attr("style", "background: url('pic/face/" + $(this).attr("id") + "25.png')");
        $("div.sp_25").attr("id", $(this).attr("id"));
    });

    $("#setting_photo_save").click(function(){
        var photo = $("div.sp_160").attr("id");
        $.get("../uinfo", {
            photo: photo
        },function(xml){
            if ($(xml).find("status").text() == "OK"){
                alert("设置成功");
            }
            else {
                alert("设置失败，请重新设置");
            }
        });
    });
});

function clicktab(target) {
    $(".selected_tab").addClass("closed_tab").removeClass("selected_tab");
    $("div.us_d_wrap > div").addClass("mask");
    $("div.us_d_wrap > form").addClass("mask");
    $(target).removeClass("closed_tab").addClass("selected_tab");
}
