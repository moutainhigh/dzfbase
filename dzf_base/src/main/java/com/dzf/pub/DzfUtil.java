package com.dzf.pub;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.servlet.jsp.JspWriter;

import com.dzf.pub.lang.DZFDate;

public class DzfUtil {
	
	//人民币
	public static String PK_CNY="00000100AA10000000000BKT";
	
	
	public static final Integer THIRTEENSCHEMA =0;//13行业方案
	
	public static final Integer SEVENSCHEMA= 1; //07行业方案

	public static final Integer POPULARSCHEMA =2;//民间方案
	
	public static final Integer CAUSESCHEMA = 3;;//事业方案
	
	
	//极光推送KEY
	public static String MASTERSECRET="7b358c5272bd6b10efbd9c90";
	public static String JPUSHAPPKEY="2e0353fb2e531954a5f2406c";
	
	/**
	 * 极光推送KEY,小薇无忧APP平台
	 */
	public static String MASTERSECRET_ADMIN="18a11e9a0bc4af66343f0b7b";
	public static String JPUSHAPPKEY_ADMIN="d39f5f9c5d2e1221b11bf88c";
	
	public static Set<String> month = new LinkedHashSet<String>();
	static{
		 month.add("01");
		month.add("02");
		month.add("03");
		month.add("04");
		month.add("05");
		month.add("06");
		month.add("07");
		month.add("08");
		month.add("09");
		month.add("10");
		month.add("11");
		month.add("12");
	}
	
	public static Set<String> years =new LinkedHashSet<String>();
	static{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Calendar ca = Calendar.getInstance();//得到一个Calendar的实例 
		ca.setTime(new Date()); //设置时间为当前时间 
//		ca.add(Calendar.YEAR, +1); //年份增1 
		Date year = ca.getTime();
		years.add(sdf.format(year));
		for(int i = 0;i<20;i++){
			ca.setTime(new Date());
			ca.add(Calendar.YEAR, -i); //年份减1 
			year = ca.getTime();
			years.add(sdf.format(year));
		}
	}
	/*static{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		for(int i = 0;i<10;i++){
			Calendar ca = Calendar.getInstance();//得到一个Calendar的实例 
			ca.setTime(new Date()); //设置时间为当前时间 
			ca.add(Calendar.YEAR, -i); //年份减1 
			Date year = ca.getTime();
			years.add(sdf.format(year));
		}
	}*/
	public static void WriteYearOption(JspWriter out) {
		for (String year: years) {
			try {
				out.write("<option  value="+year+">"+year +"</option>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
		public static void WriteMonthOption(JspWriter out) {
			for (String m: month) {
				try {
					out.write("<option value="+m+">"+m+"</option>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
	}
		public static void WriteYearOptionNew(JspWriter out,DZFDate datesa) {
			for (String year: years) {
					try {
						if(Integer.parseInt(year)>=datesa.getYear()){
							out.write("<option  value="+year+">"+year +"</option>");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
			}
			
		}
			public static void WriteMonthOptionNew(JspWriter out,DZFDate datesa,String logindate) {
				String jzm = datesa.toString().substring(5,7);
				boolean bool = logindate.substring(0, 4).compareTo(datesa.toString().substring(0,4)) == 0 ;
				for (String m: month) {
						try {
							if(bool){
								if(m.compareTo(jzm)>=0){
									out.write("<option value="+m+">"+m+"</option>");
								}
							}else{
								out.write("<option value="+m+">"+m+"</option>");
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
						}
				}
		}
}