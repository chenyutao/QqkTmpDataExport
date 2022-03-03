//劳动力类别
var typeData = [{
	value: '1',
	text: '返乡农民工'
}, {
	value: '2',
	text: '返乡大学生'
}, {
	value: '3',
	text: '复退军人'
}, {
	value: '4',
	text: '下乡职工'
}, {
	value: '5',
	text: '下乡科技人员'
}, {
	value: '6',
	text: '在乡就业'
}, {
	value: '7',
	text: '在家务农'
}, {
	value: '8',
	text: '灵活就业'
}, {
	value: '9',
	text: '在乡创业'
}, {
	value: '10',
	text: '在外就业'
}, {
	value: '11',
	text: '其他（在外周商、在外周才）'
}];
//文化程度
var cultureData = [{
	value: '10',
	text: '小学'
}, {
	value: '9',
	text: '初中'
}, {
	value: '8',
	text: '普通高中'
}, {
	value: '7',
	text: '技工学校'
}, {
	value: '6',
	text: '职业高中'
}, {
	value: '5',
	text: '中等专科'
}, {
	value: '4',
	text: '大学专科'
}, {
	value: '3',
	text: '大学本科'
}, {
	value: '2',
	text: '硕士研究生'
}, {
	value: '1',
	text: '博士研究生'
}, {
	value: '11',
	text: '其他'
}];
//政治面貌
var politicData = [{
	value: '13',
	text: '群众'
},{
	value: '1',
	text: '中共党员'
}, {
	value: '2',
	text: '中共预备党员'
}, {
	value: '3',
	text: '共青团员'
}, {
	value: '4',
	text: '民革会员'
}, {
	value: '5',
	text: '民盟盟员'
}, {
	value: '6',
	text: '民建会员'
}, {
	value: '7',
	text: '民进会员'
}, {
	value: '8',
	text: '农工党党员'
}, {
	value: '9',
	text: '致公党党员'
}, {
	value: '10',
	text: '九三学社社员'
}, {
	value: '11',
	text: '台盟盟员'
}, {
	value: '12',
	text: '无党派民主人士'
}];
//与户主关系
var linkData = [{
	value: '100',
	text: '户主',
	children: [{
		value: "101",
		text: "户主"
	}]
}, {
	value: '200',
	text: '非户主',
	children: [{
		value: "201",
		text: "父子"
	}, {
		value: "202",
		text: "母子"
	}, {
		value: "203",
		text: "父女"
	}, {
		value: "204",
		text: "母女"
	}, {
		value: "205",
		text: "父亲"
	}, {
		value: "206",
		text: "母亲"
	}, {
		value: "207",
		text: "配偶"
	}, {
		value: "208",
		text: "其他"
	}]
}];
//就创业途径
var pathData = [{
	value: '1',
	text: '劳务协助'
}, {
	value: '2',
	text: '就地就近'
}, {
	value: '3',
	text: '居家灵活'
}, {
	value: '4',
	text: '创业带动'
}, {
	value: '5',
	text: '中介介绍'
}, {
	value: '6',
	text: '公益性岗位'
}, {
	value: '7',
	text: '自主就(创)业'
}, {
	value: '8',
	text: '其他'
}];
//从事行业
var lineData = [{
	value: '1',
	text: '农业生产'
}, {
	value: '2',
	text: '制造业'
}, {
	value: '3',
	text: '建筑业'
}, {
	value: '4',
	text: '交通运输、仓储和邮政业'
}, {
	value: '5',
	text: '批发零售'
}, {
	value: '6',
	text: '住宿餐饮'
}, {
	value: '7',
	text: '居民服务、修理和其他服务业'
}, {
	value: '8',
	text: '其他'
}];
//培训意向
var trainHopeData = [{
	value: '1',
	text: '种植技术'
}, {
	value: '2',
	text: '养殖技术'
}, {
	value: '3',
	text: '农机操作技术'
}, {
	value: '4',
	text: '动植物防疫技术'
}, {
	value: '5',
	text: '农产品销售'
}, {
	value: '6',
	text: '农业标准化及品牌建设'
}, {
	value: '7',
	text: '主体运营管理'
}, {
	value: '8',
	text: '乡村治理'
}, {
	value: '9',
	text: '农村社会事业'
}, {
	value: '10',
	text: '其他'
}];