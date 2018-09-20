package com.boot.learn.springbootlearn.utils;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;


/**
 * 
 * 计算工具类
 * 
 * @version 1.0
 * @since JDK1.7
 * @author 沈科
 * @company 上海朝阳永续信息技术有限公司
 * @copyright (c) 2018 SunTime Co'Ltd Inc. All rights reserved.
 * @date 2018年6月19日 下午5:32:23
 */
public class ArithUtils {
	//默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;
    
    /**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double ... v) {
    	double sum = 0;
    	for (double d : v) {
    		BigDecimal b1 = new BigDecimal(Double.toString(sum));
    		BigDecimal b2 = new BigDecimal(Double.toString(d));
    		sum = b1.add(b2).doubleValue();
    	}
        return sum;
    }
    
    /**
     * 提供精确的减法运算。
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }
    
    /**
     * 
     * 提供精确的乘法运算
     *
     * @param v1
     * @param v2
     * @return
     * 
     * @date 2018年6月21日 上午9:32:43
     */
    public static double multiply(double v1, double v2) {
		BigDecimal p1 = new BigDecimal(Double.toString(v1));
		BigDecimal p2 = new BigDecimal(Double.toString(v2));
	    return p1.multiply(p2).doubleValue();
	}
    
    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1,double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }
 
    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     * @param v1 被除数
     * @param v2 除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    
    /**
     * 
     * 向下取整
     * @param v1 被除数
     * @param v2 除数
     */
    public static long divFloor(double v1, double v2) {
    	if (v2 == 0) {
            throw new IllegalArgumentException(
                "The v2 must not be a positive zero");
        }
    	return (long)Math.floor(v1 / v2);
    }
    
    /**
     * 保留小数位
     *
     * @param decimal
     * @param pattern
     * @return
     * 
     * @author 牛家林
     * @date 2016年7月1日 上午9:25:19
     */
    public static String formatDecimal(Double decimal, String pattern) {
    	if (StringUtils.isBlank(pattern)) {
    		pattern = "0.00%";
    	}
    	DecimalFormat df = new DecimalFormat(pattern);
    	return df.format(decimal);
    }
    
    /**
     * 
     * 四舍五入
     *
     * @param d        值
     * @param scale    保留小数位
     * @return
     * 
     * @date 2018年6月21日 上午9:42:52
     */
    public static Double getDoubleToRound (Double d, int scale) {
		if (d == null) {
			return null;
		}
		BigDecimal b = new BigDecimal(String.valueOf(d));
		return b.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
    /**
     * 
     * 去尾
     *
     * @param d			值
     * @param scale		保留小数位
     * @return
     * 
     * @date 2018年6月21日 上午9:43:55
     */
	public static Double getDoubleToDown (Double d, int scale) {
		if (d == null) {
			return null;
		}
		BigDecimal b = new BigDecimal(String.valueOf(d));
		return b.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_DOWN).doubleValue();
	}
    
	
	public static List<String> stringSplitToList(String string) {
		List<String> set = new ArrayList<String>();
		String[] arr = string.split(",");
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		return set;
	}
	
	/**
	 * 
	 * 字符串转Double
	 *
	 * @param obj
	 * @return
	 * 
	 * @author wangleichao
	 * @date 2015年10月31日 下午2:58:17
	 */
	public static Double toDouble(String obj) {
		if(obj == null || obj.equals("")){
			return null;
		}
		if(!NumberUtils.isNumber(obj)){
			return null;
		}
		return NumberUtils.createDouble(obj);
	}

	/**
	 * StringList转LongList
	 *
	 * @param list
	 * @return
	 * 
	 * @author 牛家林
	 * @date 2016年7月22日 上午11:08:34
	 */
	public static List<Long> stringListToLong (List<String> list) {
		List<Long> longs = new ArrayList<Long>();
		if (list.isEmpty()) {
			return null;
		}
		
		for (String id : list) {
			longs.add(Long.parseLong(id));
		}
		return longs;
	}
	

	/**
	 * List<Long>转List<String>
	 *
	 * @param list
	 * @return
	 * 
	 * @author 牛家林
	 * @date 2016年10月31日 下午2:23:57
	 */
	public static List<String> longListToString (List<Long> list) {
		List<String> sList = new ArrayList<String>();
		if (list.isEmpty()) {
			return null;
		}
		
		for (Long id : list) {
			sList.add(id.toString());
		}
		return sList;
	}
	
	public static String transCodeString(String code) {
		StringBuffer result = new StringBuffer();
		char[] cs = code.toCharArray();
		int count = 0;
		for (char c : cs) {
			if ('A' <= c && c <= 'Z') {
				count++;
			}
		}
		String rs = "";
		if (count == 0) {// 6位
			result.append(cs);
		} else if (count == 1) {// 7位
			for (char c : cs) {
				if ('A' <= c && c <= 'Z') {
					rs += (c - 'A') + 10;
				} else {
					rs += c;
				}
			}
			result.append(rs);
		} else {// 9位 最后一位为数字，第7位补0，位字母转为数字和第7位调换
			char a = cs[5];
			if ('A' <= a && a <= 'Z') {
				for (int i = 0; i < cs.length - 2; i++) {
					char c = cs[i];
					if ('A' <= c && c <= 'Z') {
						if (i == 0) {
							int b = (c - 'A') + 1;
							if (b < 10) {
								rs += 0 + "" + b;
							} else {
								rs += b;
							}
						} else {
							rs += (c - 'A') + 10;
						}
					} else {
						rs += c;
					}
				}
				result.append(rs + ((a - 'A') + 10) + cs[4]);
				result.append(rs + ((a - 'A') + 36) + cs[4]);
			} else {
				for (int i = 0; i < cs.length; i++) {
					char c = cs[i];
					if ('A' <= c && c <= 'Z') {
						if (i == 0) {
							int b = (c - 'A') + 1;
							if (b < 10) {
								rs += 0 + "" + b;
							} else {
								rs += b;
							}
						} else {
							rs += (c - 'A') + 10;
						}
					} else {
						if (i == 4) {
							rs += 0 + "" + c;
						} else {
							rs += c;
						}
					}
				}
				result.append(rs);
			}
		}
		return result.toString();
	}
 
	/**
	 * 
	 * 保留四位小数
	 * 
	 * @param value
	 * @return
	 *
	 * @author 洪林映
	 * @date 2018年1月25日 下午1:47:49
	 */
	public static String formatDecimal(Double db) {
		//四舍五入
		BigDecimal bd = new BigDecimal(db).setScale(4, BigDecimal.ROUND_HALF_UP);
		// String bd = String.format("%.4f", db);  
		return bd.toString();
	}
	
	/**
	 * 
	 * 保留两位小数百分化
	 * 
	 * @param value
	 * @return
	 *
	 * @author 洪林映
	 * @date 2018年1月25日 下午1:47:49
	 */
	public static String formatPercent(Double value) {
		Double db = value*100;
		//四舍五入
		BigDecimal bd = new BigDecimal(db).setScale(2, BigDecimal.ROUND_HALF_UP);
		// String bd = String.format("%.2f", db);
		return bd+"%";
	}
	
	/**
	 * 
	 * BigDecimal格式化两位并加%
	 *
	 * @param db
	 * @return
	 * 
	 * @author 张杰
	 * @date 2018年9月14日 上午10:00:49
	 */
	public static String formatBigDecimal(BigDecimal db) {
		BigDecimal setScale = db.setScale(4, BigDecimal.ROUND_HALF_UP);
		NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(2);
        return percent.format(setScale.doubleValue());
	}
	
}
