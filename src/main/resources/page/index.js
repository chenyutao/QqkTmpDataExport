/**
 * 条件选择
 */
(function($, doc) {
	$.init();
	$.ready(function() {
		/**
		 * 获取对象属性的值
		 * 主要用于过滤三级联动中，可能出现的最低级的数据不存在的情况，实际开发中需要注意这一点；
		 * @param {Object} obj 对象
		 * @param {String} param 属性名
		 */
		var _getParam = function(obj, param) {
			return obj[param] || '';
		};

		//人员类别
		var typePicker = new $.PopPicker();
		typePicker.setData(typeData);
		var showTypePickerText = doc.getElementById('showTypePicker');
		showTypePickerText.addEventListener('tap', function(event) {
			typePicker.show(function(items) {
				showTypePickerText.value = items[0].text;
				memberType = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//民族
		var nationPicker = new $.PopPicker();
		nationPicker.setData(nationData);
		var showNationPickerText = doc.getElementById('showNationPicker');
		showNationPickerText.addEventListener('tap', function(event) {
			nationPicker.show(function(items) {
				showNationPickerText.value = items[0].text;
				nation = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//文化程度
		var culturePicker = new $.PopPicker();
		culturePicker.setData(cultureData);
		var showCulturePickerText = doc.getElementById('showCulturePicker');
		showCulturePickerText.addEventListener('tap', function(event) {
			culturePicker.show(function(items) {
				showCulturePickerText.value = items[0].text;
				education = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//政治面貌
		var politicPicker = new $.PopPicker();
		politicPicker.setData(politicData);
		var showPoliticPickerText = doc.getElementById('showPoliticPicker');
		showPoliticPickerText.addEventListener('tap', function(event) {
			politicPicker.show(function(items) {
				showPoliticPickerText.value = items[0].text;
				politicalType = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//脱贫状态
		var povertyPicker = new $.PopPicker();
		povertyPicker.setData([{
			value: '2',
			text: '非贫困户'
		}, {
			value: '1',
			text: '原贫困户'
		}, {
			value: '3',
			text: '低收入户'
		}]);
		var showPovertyPickerText = doc.getElementById('showPovertyPicker');
		showPovertyPickerText.addEventListener('tap', function(event) {
			povertyPicker.show(function(items) {
				showPovertyPickerText.value = items[0].text;
				economicStatus = items[0].value;
			});
		}, false);
		//健康状态
		var healthPicker = new $.PopPicker();
		healthPicker.setData([{
			value: '1',
			text: '健康'
		}, {
			value: '2',
			text: '长期慢性病'
		}, {
			value: '3',
			text: '残疾'
		}]);
		var showHealthPickerText = doc.getElementById('showHealthPicker');
		showHealthPickerText.addEventListener('tap', function(event) {
			healthPicker.show(function(items) {
				showHealthPickerText.value = items[0].text;
				healthStatus = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//就（创）业途径
		var pathPicker = new $.PopPicker();
		pathPicker.setData(pathData);
		var showPathPickerText = doc.getElementById('showPathPicker');
		showPathPickerText.addEventListener('tap', function(event) {
			pathPicker.show(function(items) {
				showPathPickerText.value = items[0].text;
				businessChannel = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//就（创）业从事行业
		var linePicker = new $.PopPicker();
		linePicker.setData(lineData);
		var showLinePickerText = doc.getElementById('showLinePicker');
		showLinePickerText.addEventListener('tap', function(event) {
			linePicker.show(function(items) {
				showLinePickerText.value = items[0].text;
				industry = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//家庭服务业从业类型
		var waiterTypePicker = new $.PopPicker();
		waiterTypePicker.setData([{
			value: '1',
			text: '家庭服务'
		}, {
			value: '2',
			text: '养老服务'
		}, {
			value: '3',
			text: '社区照料服务'
		}, {
			value: '4',
			text: '病患服务'
		}, {
			value: '5',
			text: '其他'
		}]);
		var showWaiterTypePickerText = doc.getElementById('showWaiterTypePicker');
		showWaiterTypePickerText.addEventListener('tap', function(event) {
			waiterTypePicker.show(function(items) {
				showWaiterTypePickerText.value = items[0].text;
				workType = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//输出渠道
		var ditchPicker = new $.PopPicker();
		ditchPicker.setData([{
			value: '1',
			text: '有组织输出'
		}, {
			value: '2',
			text: '自发外出'
		}, {
			value: '3',
			text: '本地就业'
		}]);
		var showDitchPickerText = doc.getElementById('showDitchPicker');
		showDitchPickerText.addEventListener('tap', function(event) {
			ditchPicker.show(function(items) {
				showDitchPickerText.value = items[0].text;
				laborChannel = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//劳动力类型
		var skillPicker = new $.PopPicker();
		skillPicker.setData([{
			value: '1',
			text: '技能劳动力'
		}, {
			value: '2',
			text: '普通劳动力'
		}]);
		var showSkillPickerText = doc.getElementById('showSkillPicker');
		showSkillPickerText.addEventListener('tap', function(event) {
			skillPicker.show(function(items) {
				showSkillPickerText.value = items[0].text;
				workSkills = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//未就业原因
		var outWorkPicker = new $.PopPicker();
		outWorkPicker.setData([{
			value: '1',
			text: '正在找工作'
		}, {
			value: '2',
			text: '务农'
		}, {
			value: '3',
			text: '顾家'
		}, {
			value: '4',
			text: '暂时丧失劳动力'
		}, {
			value: '5',
			text: '无就业意向'
		}]);
		var showOutWorkPickerText = doc.getElementById('showOutWorkPicker');
		showOutWorkPickerText.addEventListener('tap', function(event) {
			outWorkPicker.show(function(items) {
				showOutWorkPickerText.value = items[0].text;
				notWorkReason = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//培训类型
		var trainTypePicker = new $.PopPicker();
		trainTypePicker.setData([{
			value: '1',
			text: '引导性培训'
		}, {
			value: '2',
			text: '技能性培训'
		}]);
		var showTrainTypePickerText = doc.getElementById('showTrainTypePicker');
		showTrainTypePickerText.addEventListener('tap', function(event) {
			trainTypePicker.show(function(items) {
				showTrainTypePickerText.value = items[0].text;
				trainedType = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//培训意向
		var trainHopePicker = new $.PopPicker();
		trainHopePicker.setData(trainHopeData);
		var showTrainHopePickerText = doc.getElementById('showTrainHopePicker');
		showTrainHopePickerText.addEventListener('tap', function(event) {
			trainHopePicker.show(function(items) {
				showTrainHopePickerText.value = items[0].text;
				trainPlan = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//下一步就业意愿
		var workHopePicker = new $.PopPicker();
		workHopePicker.setData([{
			value: '1',
			text: '返岗'
		}, {
			value: '2',
			text: '外出再就业'
		}, {
			value: '3',
			text: '本地就业'
		}, {
			value: '4',
			text: '本地创业'
		}, {
			value: '5',
			text: '外出创业'
		}]);
		var showWorkHopePickerText = doc.getElementById('showWorkHopePicker');
		showWorkHopePickerText.addEventListener('tap', function(event) {
			workHopePicker.show(function(items) {
				showWorkHopePickerText.value = items[0].text;
				nextWorkPlan = items[0].value;
				//返回 false 可以阻止选择框的关闭
				//return false;
			});
		}, false);
		//-----------------------------------------
		//级联示例
		var linkPicker = new $.PopPicker({
			layer: 2
		});
		linkPicker.setData(linkData);
		var showLinkPickerText = doc.getElementById('showLinkPicker');
		showLinkPickerText.addEventListener('tap', function(event) {
			linkPicker.show(function(items) {
				showLinkPickerText.value = items[1].text;
				if(items[0].value == 100) {
					headHousehold = 1;
				} else {
					headHousehold = 0;
				}
				relationHeadHousehold = items[1].value;
			});
		}, false);
		//-----------------------------------------
		//根据接口获取乡村级信息
		//		var id = 0; //省级信息
		function getValueArr(id, value) {
			var tmpArr = [];
			// url = "http://api-test.zkyjr.ssnyjt.com/api/area/list?id=" + id;
			url = "https://api.zkyjr.ssnyjt.com:4430/api/area/list?id=" + id;
			mui.ajax(url, {
				dataType: 'json', //服务器返回json格式数据  
				type: 'get', //HTTP请求类型  
				headers: {
					'Content-Type': 'application/json'
				},
				timeout: 10000, //超时时间设置为10秒；  
				success: function(res) {
					if(res.code == 200) {
						if(res.data.length == 0) {
							value.setData([{
								value: '-1',
								text: '无'
							}]);
						} else {
							for(var i = 0; i < res.data.length; i++) {
								tmpArr.push({
									value: res.data[i].id,
									text: res.data[i].fullName,
								});
							}
							value.setData(tmpArr);
						}

					} else {
						mui.alert(res.msg);
					}
				},
				error: function(xhr, type, errorThrown) {
					//异常处理； 
					mui.alert("数据请求失败，请刷新页面重试！");
					console.log(type);
				}
			});

		}

		//					//级联示例
		var cityPicker3 = new $.PopPicker({
			layer: 3
		});

		cityPicker3.setData(cityData3); //省市县
		cityPicker3.pickers[0].setSelectedValue('410000');
		setTimeout(function() {
			cityPicker3.pickers[1].setSelectedValue('411600');
		}, 300)
		//定义籍贯乡镇
		var townPicker = new $.PopPicker();
		//籍贯省市县
		var showhjCityPickerText = doc.getElementById('showhjCityPicker');
		showhjCityPickerText.addEventListener('tap', function(event) {
			doc.getElementById('showhjTownPicker').value = "";
			doc.getElementById('showhjVillagePicker').value = "";
			cityPicker3.show(function(items) {
				showhjCityPickerText.value = _getParam(items[0], 'text') + "" + _getParam(items[1], 'text') + "" + _getParam(items[2], 'text');
				householdProvinceId = _getParam(items[0], 'value');
				householdCityId = _getParam(items[1], 'value');
				householdCountyId = _getParam(items[2], 'value');
				getValueArr(householdCountyId, townPicker);
			});
		}, false);
		//定义籍贯行政村
		var villagePicker = new $.PopPicker();
		//选择乡镇
		var showhjTownPickerText = doc.getElementById('showhjTownPicker');
		showhjTownPickerText.addEventListener('tap', function(event) {
			doc.getElementById('showhjVillagePicker').value = "";
			townPicker.show(function(items) {
				showhjTownPickerText.value = items[0].text;
				householdTownId = items[0].value;
				getValueArr(householdTownId, villagePicker);
			});
		}, false);
		//选择行政村
		var showhjVillagePickerText = doc.getElementById('showhjVillagePicker');
		showhjVillagePickerText.addEventListener('tap', function(event) {
			villagePicker.show(function(items) {
				showhjVillagePickerText.value = items[0].text;
				householdVillageId = items[0].value;
			});
		}, false);
		//创（就）业地
		var showcyCityPickerText = doc.getElementById('showcyCityPicker');
		showcyCityPickerText.addEventListener('tap', function(event) {
			cityPicker3.show(function(items) {
				showcyCityPickerText.value = _getParam(items[0], 'text') + "" + _getParam(items[1], 'text') + "" + _getParam(items[2], 'text');
				console.log(items);
				businessProvinceId = _getParam(items[0], 'value');
				businessCountyId = _getParam(items[1], 'value');
				businessCityId = _getParam(items[2], 'value');
			});
		}, false);

	});
	//---------------------时间选择器--------------------------
	//出生日期
	//	var birthDateText = document.querySelector('#birthDate');
	//	var birthDatePicker = new mui.DtPicker({
	//		type: 'date',
	//		beginYear: '1963',
	//		endYear: '2006'
	//	});
	//	// 监听日期选择点击事件
	//	birthDateText.addEventListener('tap', function() {
	//		birthDatePicker.show(function(selectItems) {
	//			birthDateText.value = selectItems.value;
	//		})
	//	}, false);
	//就（创）业日期
	var workDateText = document.querySelector('#workDate');
	var workDatePicker = new mui.DtPicker({
		type: 'month',
		beginYear: '1963',
		endYear: '2022'
	});
	// 监听日期选择点击事件
	workDateText.addEventListener('tap', function() {
		workDatePicker.show(function(selectItems) {
			workDateText.value = selectItems.value;
		})
	}, false);
	//返乡日期
	var backDateText = document.querySelector('#backDate');
	var backDatePicker = new mui.DtPicker({
		type: 'date'
	});
	// 监听日期选择点击事件
	backDateText.addEventListener('tap', function() {
		backDatePicker.show(function(selectItems) {
			backDateText.value = selectItems.value;
		})
	}, false);
	//拟外出日期
	var goOutDateText = document.querySelector('#goOutDate');
	var goOutDatePicker = new mui.DtPicker({
		type: 'date'
	});
	// 监听日期选择点击事件
	goOutDateText.addEventListener('tap', function() {
		goOutDatePicker.show(function(selectItems) {
			goOutDateText.value = selectItems.value;
		})
	}, false);

})(mui, document);

/////////////////////////////////////五级联动//////////////////////
/*
 * 五级联动
 * provId 省下拉框的id  为了摆放拼接的字符串
 * cityId 市下拉框的id
 * countyId 县下拉框的id
 * townId 乡下拉框的id
 * villageId 村拉框的id 
 * dataprovId 为了返回数据时有默认的选中状态的值
 * datacityId cityParentId 市的父级id ：省的id 一下是为了修改返回数据时下拉框有内容
 * datacountyId countyParentId 县的父级id
 * datatownId townParentId 乡的父级id
 * datavillageId villageParentId 村的父级id
 */
//function showRegion(provId, cityId, countyId, townId, villageId, dataprovId, datacityId,
//	datacountyId, datatownId, datavillageId) {
//	/*
//	 * 存放市县乡村的父级id
//	 */
//	var cityParentId = dataprovId; //市的父级id ：省的id 一下是为了修改返回数据时下拉框有内容
//	var countyParentId = datacityId; //县的父级id
//	var townParentId = datacountyId; //乡的父级id
//	var villageParentId = datatownId; //村的父级id
//	/*
//	 * 来搜索省
//	 */
//	searchByParentid(provId);
//	// stringOption(providlist, provId);
//	if(cityParentId != null) {
//		//默认选定给定的内容
//		$("#" + provId).val(dataprovId);
//		//$("#"+provId+" option[value='"+dataprovId+"']").attr("selected", "selected")
//		//$("#prov option[value='13']").prop("selected", "selected");
//		//$("#prov").val("13");
//		//$("#prov option:contains('河北省')").attr("selected", true);
//		//$("#prov").get(0).selectedIndex = 13;
//		//$("#prov").find("option[value='13']").attr("selected",true);
//		//为了搜索出当前数据
//		searchByParentid(cityId, cityParentId);
//		//默认选定给定的内容
//		$("#" + cityId).val(datacityId);
//	}
//	if(countyParentId != null) {
//		//为了搜索出所需省市县的内容
//		searchByParentid(countyId, countyParentId);
//		//默认选定给定的内容
//		$("#" + countyId).val(datacountyId);
//	}
//	if(townParentId != null) {
//		//为了搜索出所需省市县的内容
//		searchByParentid(townId, townParentId);
//		//默认选定给定的内容
//		$("#" + townId).val(datatownId);
//	}
//	if(villageParentId != null) { //为了搜索出所需省市县的内容
//		searchByParentid(villageId, villageParentId);
//		//默认选定给定的内容
//		$("#" + villageId).val(datavillageId);
//	}
//
//	/*
//	 * 省变化加载市
//	 */
//	changeRegion(provId, cityId)
//	/*
//	 * 省变化加载市
//	 */
//	changeRegion(cityId, countyId)
//
//	/*
//	 * 省变化加载市
//	 */
//	changeRegion(countyId, townId)
//	/*
//	 * 省变化加载市
//	 */
//	changeRegion(townId, villageId)
//
//}
///*
// * 根据父id搜索数据list id 搜索出数据后摆放的位置 Parentid 根据父级id来搜索
// */
//function searchByParentid(id, Parentid) {
//	myajax = $.ajax({
//		type: "post",
//		url: basePath + "/region/searchByparentId.do",
//		async: false,
//		dataType: 'json',
//		data: {
//			re_parent: Parentid,
//		},
//		success: function(data) {
//			var options = "";
//			$.each(data, function(index, item) {
//				options += "<option value=" + item.id + ">" + item.re_name +
//					"</option>";
//			});
//			$("#" + id).html(options);
//
//		},
//		error: function(data, type, err) {
//			alert("错误类型：" + type + "; 错误信息：" + err);
//		}
//	});
//}
///*
// * 通过遍历来进行拼接option下拉框
// */
//function stringOption(data, id) {
//	var options = "";
//	$.each(data, function(index, item) {
//		options += "<option value=" + item.id + ">" + item.re_name +
//			"</option>";
//	});
//	$("#" + id).html(options);
//}
///*
// * 下拉框改变 后 搜索下一级的数据 id是改变的下拉框id nextid是下一级的id
// */
//function changeRegion(id, nextid) {
//	$("#" + id).change(function() {
//		var parentId = $("#" + id).val();
//		// alert(a);
//		alert(parentId);
//		searchByParentid(nextid, parentId);
//	});
//}
//showRegion("prov", "city", "county", "town", "village", "13", "1302", "130205", "130205002");