package search;

public interface variableStatic{
//	String URL = ;
	String profilepath="count.properties"; 
	String filePathRoot = "resource/file/";
	String fileDoxNameTail = ".docx";
	String filePdfNameTail = ".docx";
	String outPutPathRoot  = "resource/output/";
    String NAME="sa";
    String PASSWORD="svrcomputer";
    String COMPANYNAME = "";
    String pzlb[] = {"大型汽车","小型汽车","外籍汽车","两、三轮摩托车","轻便摩托车","农用运输车","挂车","教练汽车","警用汽车","大型新能源汽车","小型新能源汽车"};
    String tables[] = {"委托书","人工检验表","汽车排放外检表","牌证申请表","补充申请表","载货汽车表","牵引车辆表","客车表","挂车表","性能检测判定表"};
    String rlzlTables[][] = {{"A","汽油"},{"B","柴油"},{"C","电"},{"D","混合油"},{"E","天然气"},{"F","液化石油气"},{"L","甲醇"},{"M","乙醇"},{"N","太阳能"},{"O","混合动力"},{"P","氢"},{"Q","生物燃料"},{"Y","无"}};
    String types[][] = {{"01","大型汽车"},{"02","小型汽车"},{"06","外籍汽车"},{"07","两、三轮摩托车"},{"08","轻便摩托车"},{"13","农用运输车"},{"15","挂车"},{"16","教练汽车"},{"23","警用汽车"},{"51","大型新能源汽车"},{"52","小型新能源汽车"}};
    String typeColor[][] = {{"A","白"},{"B","灰"},{"C","黄"},{"D","粉"},{"E","红"},{"F","紫"},{"G","绿"},{"H","蓝"},{"I","棕色"},{"J","黑色"},{"K","未识别"},{"Z","其他"}};
    String typeColor_Site[][] = {{"H","蓝"},{"C","黄"},{"G","绿"},{"A","白"},{"J","黑色"}};
    String frameIds[] = {"addWaitWinIframe","addWaitWinIframe"};
    String inputFields[][] = {{"2","_easyui_textbox_input89"},{"1","_easyui_textbox_input67"},{},{},{}};
    String qrfileds[] = 
    	{	"${platnum}","${vin}","${CSYS}","${owner}","${CCDJRQ}",
			"${CLCCRQ}","${brand}","${GCJK}","${crosght}","${ZBZL}",
			"${hdzzl}","${ZKRS}","${XH}","${engineModel}","${fuelType}",
			"${FDJH}","${factoryName}","${transimissionType}","${posite}","${fuelSupplyMethod}",
			"${airSupethod}","${LTSL}","${power}","${ratepeed}","${PL}",
			"${usage}","${address}","${tel}","${postcode}","${hdzzl}",
			"${sfzmhm}","${numOfCylinder}"
		};
    String SYXZTypes[][] = {
    		{"A","非营运"},{"Z","其他"},{"C","公交客运"},{"D","出租客运"},{"E","旅游客运"},{"F","货运"},
    		{"G","租赁"},{"H","警用"},{"I","消防"},{"J","救护"},{"K","工程救险"},{"L","营转非"},
    		{"M","出租转非"},{"N","教练"},{"O","幼儿校车"},{"P","小学生校车"},{"Q","其他校车"},{"R","危化品运输"},
    		{"B","公路客运"}
    					
    };
	}
