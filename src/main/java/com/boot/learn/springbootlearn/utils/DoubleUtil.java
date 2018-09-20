package com.boot.learn.springbootlearn.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;


public class DoubleUtil {

	
	/**
	 * 判断如果double小数位0则去掉
	 * @param
	 * @param
	 * @return
	 * 
	 * @author 张晓辰
	 * @date 2017年11月14日 上午10:58:12
	 */
	public static String doubleTrans1(double num){
	    if(num % 1.0 == 0){
		        return String.valueOf((long)num);
	    }
	    return String.valueOf(num);
	}
	
	public static Double doubleTrans2(double a) {
	    double b=Math.round(a*10000)/10000.0000;//保留四位小数
	    return b;
	}
	
	public static Double doubleTrans3(double a) {
	    double b=Math.round(a*10000)/10000.00;//保留2位小数
	    return b;
	}
	
	public static Object getGteZero(Object d){
		if(d == null) {
			return d;
		}
		if(Double.parseDouble(d.toString())>0d) {
			return 0.0d;
		}
		return d;
	}

	public static Double getDoubleToRound (Double d, int scale) {//四舍五入
		if (d == null) {
			return null;
		}
		BigDecimal b = new BigDecimal(String.valueOf(d));
		return b.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static Double getDoubleToDown (Double d, int scale) {//去尾
		if (d == null) {
			return null;
		}
		BigDecimal b = new BigDecimal(String.valueOf(d));
		return b.divide(BigDecimal.ONE, scale, BigDecimal.ROUND_DOWN).doubleValue();
	}
	
	
	/**
	 * 
	 * 两个double想除  
	 *
	 * @param 被除数
	 * @param 除数
	 * @return
	 * 
	 * @author majc
	 * @date 2016年1月12日 上午10:58:12
	 */
	public static Double getDivide(Double d1,Double d2){
		if(d1 == null || d2 == null || d2 == 0d){
			return null;
		}
//		BigDecimal bd = new BigDecimal(d1);
//		return bd.divide(new BigDecimal(d2), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
		return d1/d2;
	}
	
	public static Double getDivideTwo(Double d1,Double d2){
		if(d1 == null || d2 == null || d2 == 0d){
			return null;
		}
		BigDecimal bd = new BigDecimal(d1);
		return bd.divide(new BigDecimal(d2), 10, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	/**
	 * 
	 * 两个double相乘 
	 *
	 * @param
	 * @param
	 * @return
	 * 
	 * @author majc
	 * @date 2016年1月12日 上午10:58:12
	 */
	public static Double getMultiply(Double d1,Double d2){
		if(d1 == null || d2 == null){
			return null;
		}
//		BigDecimal bd = new BigDecimal(d1);
//		return bd.multiply(new BigDecimal(d2), MathContext.DECIMAL64).doubleValue();
		return d1*d2;
	}
	
	/**
	 * 
	 * 两个double相乘 
	 *
	 * @param
	 * @param
	 * @return
	 * 
	 * @author majc
	 * @date 2016年1月12日 上午10:58:12
	 */
	public static Double getMultiplyTow(Double d1,Double d2){
		if(d1 == null || d2 == null){
			return null;
		}
		 BigDecimal p1 = new BigDecimal(Double.toString(d1));
		 BigDecimal p2 = new BigDecimal(Double.toString(d2));
	     return p1.multiply(p2).doubleValue();
	}
	
	
	/**
     * 提供精确的加法运算。
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    
    public static double add(double ... v){
    	double sum = 0;
    	for(double d : v){
    		BigDecimal b1 = new BigDecimal(Double.toString(sum));
    		BigDecimal b2 = new BigDecimal(Double.toString(d));
    		sum = b1.add(b2).doubleValue();
    	}
        return sum;
    }
	
    /**
	 * 
	 * 提供精确的减法运算。
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 *
	 * @author 张晓辰
	 * @date 2017年12月11日 下午2:07:16
	 */
    public static double sub(double d1,double d2){ 
        BigDecimal bd1 = new BigDecimal(Double.toString(d1)); 
        BigDecimal bd2 = new BigDecimal(Double.toString(d2)); 
        return bd1.subtract(bd2).doubleValue(); 
    } 
    
    public static String get00(double d){
    	  DecimalFormat df = new DecimalFormat ( "###,##0.00" ) ;
          return df.format (d);
 
    }
    
    /**
     * 保留两位小数百分化
     *
     * @param value
     * @return
     * 
     * @author 王傲杰
     * @date 2018年7月25日 下午2:27:01
     */
	public static String format3(Double value) {
		Double db = value * 100;
		// 四舍五入
		String bd = String.format("%.2f", db);
		return bd + "%";
	}

	/**
	 *
	 * 去尾法 - 负数去尾后比原始值小
	 *
	 * @param d
	 * @return
	 *
	 * @author shenke
	 * @date 2018年8月9日 上午10:41:56
	 */
	public static Double getDoubleToDownMinus (Double d) {
		if (d == null) {
			return null;
		}
		BigDecimal b = new BigDecimal(String.valueOf(d));
		double value = b.divide(BigDecimal.ONE, 4, BigDecimal.ROUND_DOWN).doubleValue();
		if (d < 0 && value > d) {
			return value - 0.0001;
		}
		return value;
	}
    
}
