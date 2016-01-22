import static java.util.Calendar.*;

import java.util.GregorianCalendar;
import java.util.Scanner;

class Calender{
	private Days day1;
	private Days day2;
	private int date;

	public Calender(){ }
	public Calender(Days day){
		this.day1 = new Days(day);
	}
	public Calender(Days day1, Days day2){
		set(day1,day2);
	}
	public void set(Days day1, Days day2){
		this.day1 = new Days(day1);
		this.day2 = new Days(day2);
	}
	public int calenderId(Days day){
		int cal = 146097*(day.getYear()-1720)/400;
		if(day.getYear()%400 > 20 && day.getYear()%400 < 52){
			if(day.getYear()%4 == 1) cal += 1;
		}
		if(day.getYear()%400 > 52 && day.getYear()%400 < 84){
			if(day.getYear()%4 == 1 || day.getYear()%4 == 2) cal += 1;
		}
		if(day.getYear()%400 > 84 && day.getYear()%400 < 100){
			if(day.getYear()%4 != 0) cal += 1;
		}
		if(day.getYear()%400 > 100 && day.getYear()%400 <= 120){
			if(day.getYear()%4 == 0) cal -= 1;
		}
		if(day.getYear()%400 > 156 && day.getYear()%400 < 188){
			if(day.getYear()%4 == 1) cal += 1;
		}
		if(day.getYear()%400 > 188 && day.getYear()%400 < 200){
			if(day.getYear()%4 == 1 || day.getYear()%4 == 2) cal += 1;
		}
		if(day.getYear()%400 > 200 && day.getYear()%400 < 220){
			if(day.getYear()%4 == 0 || day.getYear()%4 == 3) cal -= 1;
		}
		if(day.getYear()%400 >= 220 && day.getYear()%400 <= 256){
			if(day.getYear()%4 == 0) cal -= 1;
		}
		if(day.getYear()%400 > 288 && day.getYear()%400 < 300){
			if(day.getYear()%4 == 1) cal += 1;
		}
		if(day.getYear()%400 > 300 && day.getYear()%400 < 320){
			if(day.getYear()%4 != 1) cal -= 1;
		}
		if(day.getYear()%400 >= 320 && day.getYear()%400 < 352){
			if(day.getYear()%4 == 0 || day.getYear()%4 == 3) cal -= 1;
		}
		if(day.getYear()%400 >= 352 && day.getYear()%400 < 388){
			if(day.getYear()%4 == 0) cal -= 1;
		}
		if(day.getMonth() == 1) cal -= 89;
		if(day.getMonth() == 2) cal -= 58;
		if(day.getMonth() == 3){
			if(day.getYear()%4 == 0){
				if(day.getYear()%100 == 0){
					if(day.getYear()%400 == 0) cal -= 29;
					else cal -= 30;
				}
				else cal -= 29;
			}
			else cal -= 30;
		}
		if(day.getMonth() == 4){
			if(day.getYear()%4 == 0){
				if(day.getYear()%100 == 0){
					if(day.getYear()%400 == 0) cal += 2;
					else cal += 1;
				}
				else cal += 2;
			}
			else cal += 1;
		}
		if(day.getMonth() == 5){
			if(day.getYear()%4 == 0){
				if(day.getYear()%100 == 0){
					if(day.getYear()%400 == 0) cal += 32;
					else cal += 31;
				}
				else cal += 32;
			}
			else cal += 31;
		}
		if(day.getMonth() == 6){
			if(day.getYear()%4 == 0){
				if(day.getYear()%100 == 0){
					if(day.getYear()%400 == 0) cal += 63;
					else cal += 62;
				}
				else cal += 63;
			}
			else cal += 62;
		}
		if(day.getMonth() == 7){
			if(day.getYear()%4 == 0){
				if(day.getYear()%100 == 0){
					if(day.getYear()%400 == 0) cal += 93;
					else cal += 92;
				}
				else cal += 93;
			}
			else cal += 92;
		}
		if(day.getMonth() == 8){
			if(day.getYear()%4 == 0){
				if(day.getYear()%100 == 0){
					if(day.getYear()%400 == 0) cal += 124;
					else cal += 123;
				}
				else cal += 124;
			}
			else cal += 123;
		}
		if(day.getMonth() == 9){
			if(day.getYear()%4 == 0){
				if(day.getYear()%100 == 0){
					if(day.getYear()%400 == 0) cal += 155;
					else cal += 154;
				}
				else cal += 155;
			}
			else cal += 154;
		}
		if(day.getMonth() == 10){
			if(day.getYear()%4 == 0){
				if(day.getYear()%100 == 0){
					if(day.getYear()%400 == 0) cal += 185;
					else cal += 184;
				}
				else cal += 185;
			}
			else cal += 184;
		}
		if(day.getMonth() == 11){
			if(day.getYear()%4 == 0){
				if(day.getYear()%100 == 0){
					if(day.getYear()%400 == 0) cal += 216;
					else cal += 215;
				}
				else cal += 216;
			}
			else cal += 215;
		}
		if(day.getMonth() == 12){
			if(day.getYear()%4 == 0){
				if(day.getYear()%100 == 0){
					if(day.getYear()%400 == 0) cal += 246;
					else cal += 245;
				}
				else cal += 246;
			}
			else cal += 245;
		}
		cal += day.getDate();
		return cal;
	}
	public int getNumDates(){
		int cal1 = calenderId(day1);
		int cal2 = calenderId(day2);

		date = cal2 - cal1;
		return date;
	}

	public int kanYear(){
		int year = day1.getYear();
		return (year+6)%10;
	}

	public int shiYear(){
		int year = day1.getYear();
		return (year+8)%12;
	}

	public int kanMonth(){
		int year = day1.getYear();
		int month = day1.getMonth();
		if(year%10==0 || year%10==5) return (month+3)%10;
		else if(year%10==1 || year%10==6) return (month+5)%10;
		else if(year%10==2 || year%10==7) return (month+7)%10;
		else if(year%10==3 || year%10==8) return (month+9)%10;
		else if(year%10==4 || year%10==9) return (month+1)%10;
		return month%10;
	}

	public int shiMonth(){
		int month = day1.getMonth();
		return (month+1)%12;
	}

	public int kanDay(){
		int cal = calenderId(day1);
		return (cal+5)%10;
	}

	public int shiDay(){
		int cal = calenderId(day1);
		return (cal+7)%12;
	}

	public int nineYear(){
		int year = day1.getYear();
		int month = day1.getMonth();
		int day = day1.getDate();
		if(year%9 <= 1){
			if(month==1) return 2-year%9;
			else if(month==2){
				if((year%400>=21 && year%400<=56) || (year%400>=157 && year%400<=192) || (year%400>=285 && year%400<=300)){
					if(year%4 == 1){
						if(day<3) return 2-year%9;
						else return 1-year%9;
					}
					else if(day<4) return 2-year%9;
					else return 1-year%9;
				}
				if((year%400>=57 && year%400<=88) || (year%400>=193 && year%400<=200)){
					if(year%4 == 1 || year%4 == 2){
						if(day<3) return 2-year%9;
						else return 1-year%9;
					}
					else if(day<4) return 2-year%9;
					else return 1-year%9;
				}
				if(year%400>=89 && year%400<=100){
					if(year%4 == 0){
						if(day<4) return 2-year%9;
						else return 1-year%9;
					}
					else if(day<3) return 2-year%9;
					else return 1-year%9;
				}
				if(year%400>=301 && year%400<=316){
					if(year%4 == 1){
						if(day<4) return 2-year%9;
						else return 1-year%9;
					}
					else if(day<5) return 2-year%9;
					else return 1-year%9;
				}
				if((year%400>=201 && year%400<=216) || (year%400>=317 && year%400<=352)){
					if(year%4 == 1 || year%4 == 2){
						if(day<4) return 2-year%9;
						else return 1-year%9;
					}
					else if(day<5) return 2-year%9;
					else return 1-year%9;
				}
				if((year%400>=101 && year%400<=120) || (year%400>=217 && year%400<=248) || (year%400>=353 && year%400<=384)){
					if(year%4 == 0){
						if(day<5) return 2-year%9;
						else return 1-year%9;
					}
					else if(day<4) return 2-year%9;
					else return 1-year%9;
				}
				else if(day<4) return 2-year%9;
				else return 1-year%9;
			}
			else return 1-year%9;
		}
		else if(year%9 == 2){
			if(month==1) return 0;
			else if(month==2){
				if((year%400>=21 && year%400<=56) || (year%400>=157 && year%400<=192) || (year%400>=285 && year%400<=300)){
					if(year%4 == 1){
						if(day<3) return 0;
						else return 8;
					}
					else if(day<4) return 0;
					else return 8;
				}
				if((year%400>=57 && year%400<=88) || (year%400>=193 && year%400<=200)){
					if(year%4 == 1 || year%4 == 2){
						if(day<3) return 0;
						else return 8;
					}
					else if(day<4) return 0;
					else return 8;
				}
				if(year%400>=89 && year%400<=100){
					if(year%4 == 0){
						if(day<4) return 0;
						else return 8;
					}
					else if(day<3) return 0;
					else return 8;
				}
				if(year%400>=301 && year%400<=316){
					if(year%4 == 1){
						if(day<4) return 0;
						else return 8;
					}
					else if(day<5) return 0;
					else return 8;
				}
				if((year%400>=201 && year%400<=216) || (year%400>=317 && year%400<=352)){
					if(year%4 == 1 || year%4 == 2){
						if(day<4) return 0;
						else return 8;
					}
					else if(day<5) return 0;
					else return 8;
				}
				if((year%400>=101 && year%400<=120) || (year%400>=217 && year%400<=248) || (year%400>=353 && year%400<=384)){
					if(year%4 == 0){
						if(day<5) return 0;
						else return 8;
					}
					else if(day<4) return 0;
					else return 8;
				}
				else if(day<4) return 0;
				else return 8;
			}
			else return 8;
		}
		else if(month==1) return 11-year%9;
		else if(month==2){
			if((year%400>=21 && year%400<=56) || (year%400>=157 && year%400<=192) || (year%400>=285 && year%400<=300)){
				if(year%4 == 1){
					if(day<3) return 11-year%9;
					else return 10-year%9;
				}
				else if(day<4) return 11-year%9;
				else return 10-year%9;
			}
			if((year%400>=57 && year%400<=88) || (year%400>=193 && year%400<=200)){
				if(year%4 == 1 || year%4 == 2){
					if(day<3) return 11-year%9;
					else return 10-year%9;
				}
				else if(day<4) return 11-year%9;
				else return 10-year%9;
			}
			if(year%400>=89 && year%400<=100){
				if(year%4 == 0){
					if(day<4) return 11-year%9;
					else return 10-year%9;
				}
				else if(day<3) return 11-year%9;
				else return 10-year%9;
			}
			if(year%400>=301 && year%400<=316){
				if(year%4 == 1){
					if(day<4) return 11-year%9;
					else return 10-year%9;
				}
				else if(day<5) return 11-year%9;
				else return 10-year%9;
			}
			if((year%400>=201 && year%400<=216) || (year%400>=317 && year%400<=352)){
				if(year%4 == 1 || year%4 == 2){
					if(day<4) return 11-year%9;
					else return 10-year%9;
				}
				else if(day<5) return 11-year%9;
				else return 10-year%9;
			}
			if((year%400>=101 && year%400<=120) || (year%400>=217 && year%400<=248) || (year%400>=353 && year%400<=384)){
				if(year%4 == 0){
					if(day<5) return 11-year%9;
					else return 10-year%9;
				}
				else if(day<4) return 11-year%9;
				else return 10-year%9;
			}
			else if(day<4) return 11-year%9;
			else return 10-year%9;
		}
		else return 10-year%9;
	}

	public int nineMonth(){
		int year = day1.getYear();
		int month = day1.getMonth();
		int day = day1.getDate();
		if(year%3 == 0){
			if(month==1){
				if(year%400>=93 && year%400<=100){
					if(year%4 == 1){
						if(day<4) return 3;
						else return 2;
					}
					else if(day<5) return 3;
					else return 2;
				}
				if(year%400>=301 && year%400<=316){
					if(year%4 == 0){
						if(day<7) return 3;
						else return 2;
					}
					else if(day<6) return 3;
					else return 2;
				}
				if((year%400>=201 && year%400<=216) || (year%400>=317 && year%400<=356)){
					if(day<6) return 3;
					else return 2;
				}
				if((year%400>=101 && year%400<=124) || (year%400>=217 && year%400<=248) || (year%400>=357 && year%400<=388)){
					if(year%4 == 1){
						if(day<5) return 3;
						else return 2;
					}
					else if(day<6) return 3;
					else return 2;
				}
				if((year%400>=0 && year%400<=24) || (year%400>=125 && year%400<=160) || (year%400>=249 && year%400<=284) || (year%400>=389 && year%400<=399)){
					if(year%4 == 1 || year%4 == 2){
						if(day<5) return 3;
						else return 2;
					}
					else if(day<6) return 3;
					else return 2;
				}
				if((year%400>=25 && year%400<=56) || (year%400>=161 && year%400<=192) || (year%400>=285 && year%400<=300)){
					if(year%4 == 0){
						if(day<6) return 3;
						else return 2;
					}
					else if(day<5) return 3;
					else return 2;
				}
				else if(day<5) return 3;
				else return 2;
			}
			if(month==2){
				if((year%400>=21 && year%400<=56) || (year%400>=157 && year%400<=192) || (year%400>=285 && year%400<=300)){
					if(year%4 == 1){
						if(day<3) return 2;
						else return 1;
					}
					else if(day<4) return 2;
					else return 1;
				}
				if((year%400>=57 && year%400<=88) || (year%400>=193 && year%400<=200)){
					if(year%4 == 1 || year%4 == 2){
						if(day<3) return 2;
						else return 1;
					}
					else if(day<4) return 2;
					else return 1;
				}
				if(year%400>=89 && year%400<=100){
					if(year%4 == 0){
						if(day<4) return 2;
						else return 1;
					}
					else if(day<3) return 2;
					else return 1;
				}
				if(year%400>=301 && year%400<=316){
					if(year%4 == 1){
						if(day<4) return 2;
						else return 1;
					}
					else if(day<5) return 2;
					else return 1;
				}
				if((year%400>=201 && year%400<=216) || (year%400>=317 && year%400<=352)){
					if(year%4 == 1 || year%4 == 2){
						if(day<4) return 2;
						else return 1;
					}
					else if(day<5) return 2;
					else return 1;
				}
				if((year%400>=101 && year%400<=120) || (year%400>=217 && year%400<=248) || (year%400>=353 && year%400<=384)){
					if(year%4 == 0){
						if(day<5) return 2;
						else return 1;
					}
					else if(day<4) return 2;
					else return 1;
				}
				else if(day<4) return 2;
				else return 1;
			}
			if(month==3){
				if(year%400>=88 && year%400<=99){
					if(year%4 == 0){
						if(day<4) return 1;
						else return 0;
					}
					else if(day<5) return 1;
					else return 0;
				}
				if(year%400>=300 && year%400<=319){
					if(year%4 == 3){
						if(day<7) return 1;
						else return 0;
					}
					else if(day<6) return 1;
					else return 0;
				}
				if((year%400>=200 && year%400<=223) || (year%400>=320 && year%400<=355)){
					if(day<6) return 1;
					else return 0;
				}
				if((year%400>=100 && year%400<=119) || (year%400>=224 && year%400<=255) || (year%400>=356 && year%400<=387)){
					if(year%4 == 0){
						if(day<5) return 1;
						else return 0;
					}
					else if(day<6) return 1;
					else return 0;
				}
				if((year%400>=0 && year%400<=19) || (year%400>=120 && year%400<=155) || (year%400>=256 && year%400<=287) || (year%400>=388 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 1;
						else return 0;
					}
					else if(day<6) return 1;
					else return 0;
				}
				if((year%400>=20 && year%400<=51) || (year%400>=156 && year%400<=183) || (year%400>=288 && year%400<=299)){
					if(year%4 == 3){
						if(day<6) return 1;
						else return 0;
					}
					else if(day<5) return 1;
					else return 0;
				}
				else if(day<5) return 1;
				return 0;
			}
			if(month==4){
				if((year%400>=0 && year%400<=15) || (year%400>=112 && year%400<=139) || (year%400>=256 && year%400<=283) || (year%400>=384 && year%400<=399)){
					if(year%4 == 0){
						if(day<4) return 0;
						else return 8;
					}
					else if(day<5) return 0;
					else return 8;
				}
				if((year%400>=16 && year%400<=43) || (year%400>=140 && year%400<=171) || (year%400>=284 && year%400<=299)){
					if(year%4 == 0 || year%4 == 1){
						if(day<4) return 0;
						else return 8;
					}
					else if(day<5) return 0;
					else return 8;
				}
				if((year%400>=44 && year%400<=75) || (year%400>=172 && year%400<=199)){
					if(year%4 == 3){
						if(day<5) return 0;
						else return 8;
					}
					else if(day<4) return 0;
					else return 8;
				}
				if(year%400>=76 && year%400<=99){
					if(day<4) return 0;
					else return 8;
				}
				if(year%400>=300 && year%400<=315){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 0;
						else return 8;
					}
					else if(day<6) return 0;
					else return 8;
				}
				if((year%400>=200 && year%400<=219) || (year%400>=316 && year%400<=347)){
					if(year%4 == 3){
						if(day<6) return 0;
						else return 8;
					}
					else if(day<5) return 0;
					else return 8;
				}
				else if(day<5) return 0;
				return 8;
			}
			if(month==5){
				if((year%400>=72 && year%400<=99) || (year%400>=196 && year%400<=199)){
					if(year%4 == 0){
						if(day<4) return 8;
						else return 7;
					}
					else if(day<5) return 8;
					else return 7;
				}
				if(year%400>=300 && year%400<=315){
					if(year%4 == 3){
						if(day<7) return 8;
						else return 7;
					}
					else if(day<6) return 8;
					else return 7;
				}
				if((year%400>=200 && year%400<=223) || (year%400>=316 && year%400<=347)){
					if(day<6) return 8;
					else return 7;
				}
				if((year%400>=100 && year%400<=103) || (year%400>=224 && year%400<=255) || (year%400>=348 && year%400<=379)){
					if(year%4 == 0){
						if(day<5) return 8;
						else return 7;
					}
					else if(day<6) return 8;
					else return 7;
				}
				if((year%400>=0 && year%400<=7) || (year%400>=104 && year%400<=131) || (year%400>=256 && year%400<=283) || (year%400>=380 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 8;
						else return 7;
					}
					else if(day<6) return 8;
					else return 7;
				}
				if((year%400>=8 && year%400<=39) || (year%400>=132 && year%400<=159) || (year%400>=284 && year%400<=299)){
					if(year%4 == 3){
						if(day<6) return 8;
						else return 7;
					}
					else if(day<5) return 8;
					else return 7;
				}
				else if(day<5) return 8;
				return 7;
			}
			if(month==6){
				if(year%400>=92 && year%400<=99){
					if(year%4 == 0){
						if(day<4) return 7;
						else return 6;
					}
					else if(day<5) return 7;
					else return 6;
				}
				if(year%400>=300 && year%400<=307){
					if(year%4 == 0 || year%4 == 1){
						if(day<6) return 7;
						else return 6;
					}
					else if(day<7) return 7;
					else return 6;
				}
				if((year%400>=200 && year%400<=215) || (year%400>=308 && year%400<=335)){
					if(year%4 == 3){
						if(day<7) return 7;
						else return 6;
					}
					else if(day<6) return 7;
					else return 6;
				}
				if((year%400>=216 && year%400<=251) || (year%400>=336 && year%400<=371)){
					if(day<6) return 7;
					else return 6;
				}
				if((year%400>=100 && year%400<=119) || (year%400>=252 && year%400<=279) || (year%400>=372 && year%400<=387)){
					if(year%4 == 0){
						if(day<5) return 7;
						else return 6;
					}
					else if(day<6) return 7;
					else return 6;
				}
				if((year%400>=0 && year%400<=27) || (year%400>=120 && year%400<=147) || (year%400>=280 && year%400<=299) || (year%400>=388 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 7;
						else return 6;
					}
					else if(day<6) return 7;
					else return 6;
				}
				if((year%400>=28 && year%400<=59) || (year%400>=148 && year%400<=179)){
					if(year%4 == 3){
						if(day<6) return 7;
						else return 6;
					}
					else if(day<5) return 7;
					else return 6;
				}
				else if(day<5) return 7;
				return 6;
			}
			if(month==7){
				if((year%400>=24 && year%400<=51) || (year%400>=140 && year%400<=171)){
					if(year%4 == 0){
						if(day<6) return 6;
						else return 5;
					}
					else if(day<7) return 6;
					else return 5;
				}
				if((year%400>=52 && year%400<=79) || (year%400>=172 && year%400<=195)){
					if(year%4 == 0 || year%4 == 1){
						if(day<6) return 6;
						else return 5;
					}
					else if(day<7) return 6;
					else return 5;
				}
				if((year%400>=80 && year%400<=99) || (year%400>=196 && year%400<=199)){
					if(year%4 == 3){
						if(day<7) return 6;
						else return 5;
					}
					else if(day<6) return 6;
					else return 5;
				}
				if(year%400>=300 && year%400<=303){
					if(day<8) return 6;
					else return 5;
				}
				if((year%400>=200 && year%400<=211) || (year%400>=304 && year%400<=331)){
					if(year%4 == 0){
						if(day<7) return 6;
						else return 5;
					}
					else if(day<8) return 6;
					else return 5;
				}
				if((year%400>=212 && year%400<=239) || (year%400>=332 && year%400<=359)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 6;
						else return 5;
					}
					else if(day<8) return 6;
					else return 5;
				}
				if((year%400>=100 && year%400<=107) || (year%400>=240 && year%400<=271) || (year%400>=360 && year%400<=387)){
					if(year%4 == 3){
						if(day<8) return 6;
						else return 5;
					}
					else if(day<7) return 6;
					else return 5;
				}
				else if(day<7) return 6;
				return 5;
			}
			if(month==8){
				if((year%400>=72 && year%400<=99) || (year%400>=192 && year%400<=199)){
					if(year%4 == 0){
						if(day<6) return 5;
						else return 4;
					}
					else if(day<7) return 5;
					else return 4;
				}
				if(year%400>=300 && year%400<=315){
					if(year%4 == 3){
						if(day<9) return 5;
						else return 4;
					}
					else if(day<8) return 5;
					else return 4;
				}
				if((year%400>=200 && year%400<=231) || (year%400>=316 && year%400<=351)){
					if(day<8) return 5;
					else return 4;
				}
				if((year%400>=232 && year%400<=259) || (year%400>=352 && year%400<=379)){
					if(year%4 == 0){
						if(day<7) return 5;
						else return 4;
					}
					else if(day<8) return 5;
					else return 4;
				}
				if((year%400>=0 && year%400<=7) || (year%400>=100 && year%400<=127) || (year%400>=260 && year%400<=291) || (year%400>=380 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 5;
						else return 4;
					}
					else if(day<8) return 5;
					else return 4;
				}
				if((year%400>=8 && year%400<=39) || (year%400>=128 && year%400<=159) || (year%400>=292 && year%400<=299)){
					if(year%4 == 3){
						if(day<8) return 5;
						else return 4;
					}
					else if(day<7) return 5;
					else return 4;
				}
				else if(day<7) return 5;
				return 4;
			}
			if(month==9){
				if(year%400>=88 && year%400<=99){
					if(year%4 == 0){
						if(day<6) return 4;
						else return 3;
					}
					else if(day<7) return 4;
					else return 3;
				}
				if((year%400>=200 && year%400<=207) || (year%400>=300 && year%400<=331)){
					if(year%4 == 3){
						if(day<9) return 4;
						else return 3;
					}
					else if(day<8) return 4;
					else return 3;
				}
				if((year%400>=208 && year%400<=239) || (year%400>=332 && year%400<=363)){
					if(day<8) return 4;
					else return 3;
				}
				if((year%400>=100 && year%400<=115) || (year%400>=240 && year%400<=271) || (year%400>=364 && year%400<=395)){
					if(year%4 == 0){
						if(day<7) return 4;
						else return 3;
					}
					else if(day<8) return 4;
					else return 3;
				}
				if((year%400>=0 && year%400<=23) || (year%400>=116 && year%400<=147) || (year%400>=272 && year%400<=299) || (year%400>=396 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 4;
						else return 3;
					}
					else if(day<8) return 4;
					else return 3;
				}
				if((year%400>=24 && year%400<=55) || (year%400>=148 && year%400<=175)){
					if(year%4 == 3){
						if(day<8) return 4;
						else return 3;
					}
					else if(day<7) return 4;
					else return 3;
				}
				else if(day<7) return 4;
				return 3;
			}
			if(month==10){
				if((year%400>=48 && year%400<=79) || (year%400>=176 && year%400<=199)){
					if(year%4 == 0){
						if(day<7) return 3;
						else return 2;
					}
					else if(day<8) return 3;
					else return 2;
				}
				if(year%400>=80 && year%400<=99){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 3;
						else return 2;
					}
					else if(day<8) return 3;
					else return 2;
				}
				if(year%400>=300 && year%400<=319){
					if(day<9) return 3;
					else return 2;
				}
				if((year%400>=200 && year%400<=223) || (year%400>=320 && year%400<=351)){
					if(year%4 == 0){
						if(day<8) return 3;
						else return 2;
					}
					else if(day<9) return 3;
					else return 2;
				}
				if((year%400>=100 && year%400<=107) || (year%400>=224 && year%400<=251) || (year%400>=352 && year%400<=383)){
					if(year%4 == 0 || year%4 == 1){
						if(day<8) return 3;
						else return 2;
					}
					else if(day<9) return 3;
					else return 2;
				}
				if((year%400>=0 && year%400<=11) || (year%400>=108 && year%400<=139) || (year%400>=252 && year%400<=283) || (year%400>=384 && year%400<=399)){
					if(year%4 == 3){
						if(day<9) return 3;
						else return 2;
					}
					else if(day<8) return 3;
					else return 2;
				}
				else if(day<8) return 3;
				return 2;
			}
			if(month==11){
				if((year%400>=68 && year%400<=99) || (year%400>=196 && year%400<=199)){
					if(year%4 == 0){
						if(day<6) return 2;
						else return 1;
					}
					else if(day<7) return 2;
					else return 1;
				}
				if(year%400>=300 && year%400<=331){
					if(day<8) return 2;
					else return 1;
				}
				if((year%400>=200 && year%400<=231) || (year%400>=332 && year%400<=367)){
					if(year%4 == 0){
						if(day<7) return 2;
						else return 1;
					}
					else if(day<8) return 2;
					else return 1;
				}
				if((year%400>=100 && year%400<=131) || (year%400>=232 && year%400<=263) || (year%400>=368 && year%400<=387)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 2;
						else return 1;
					}
					else if(day<8) return 2;
					else return 1;
				}
				if((year%400>=0 && year%400<=31) || (year%400>=132 && year%400<=163) || (year%400>=264 && year%400<=295) || (year%400>=388 && year%400<=399)){
					if(year%4 == 3){
						if(day<8) return 2;
						else return 1;
					}
					else if(day<7) return 2;
					else return 1;
				}
				else if(day<7) return 2;
				return 1;
			}
			if(month==12){
				if((year%400>=28 && year%400<=59) || (year%400>=164 && year%400<=195) || (year%400>=292 && year%400<=299)){
					if(year%4 == 0){
						if(day<6) return 1;
						else return 0;
					}
					else if(day<7) return 1;
					else return 0;
				}
				if((year%400>=60 && year%400<=95) || (year%400>=196 && year%400<=199)){
					if(year%4 == 0 || year%4 == 1){
						if(day<6) return 1;
						else return 0;
					}
					else if(day<7) return 1;
					else return 0;
				}
				if(year%400>=96 && year%400<=99){
					if(year%4 == 3){
						if(day<7) return 1;
						else return 0;
					}
					else if(day<6) return 1;
					else return 0;
				}
				if(year%400>=300 && year%400<=323){
					if(year%4 == 0){
						if(day<7) return 1;
						else return 0;
					}
					else if(day<8) return 1;
					else return 0;
				}
				if((year%400>=200 && year%400<=219) || (year%400>=324 && year%400<=355)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 1;
						else return 0;
					}
					else if(day<8) return 1;
					else return 0;
				}
				if((year%400>=100 && year%400<=127) || (year%400>=220 && year%400<=255) || (year%400>=356 && year%400<=387)){
					if(year%4 == 3){
						if(day<8) return 1;
						else return 0;
					}
					else if(day<7) return 1;
					else return 0;
				}
				else if(day<7) return 1;
				return 0;
			}
			else return (12-month)%9;
		}
		else if(year%3 == 1){
			if(month==1){
				if(year%400>=93 && year%400<=100){
					if(year%4 == 1){
						if(day<4) return 0;
						else return 8;
					}
					else if(day<5) return 0;
					else return 8;
				}
				if(year%400>=301 && year%400<=316){
					if(year%4 == 0){
						if(day<7) return 0;
						else return 8;
					}
					else if(day<6) return 0;
					else return 8;
				}
				if((year%400>=201 && year%400<=216) || (year%400>=317 && year%400<=356)){
					if(day<6) return 0;
					else return 8;
				}
				if((year%400>=101 && year%400<=124) || (year%400>=217 && year%400<=248) || (year%400>=357 && year%400<=388)){
					if(year%4 == 1){
						if(day<5) return 0;
						else return 8;
					}
					else if(day<6) return 0;
					else return 8;
				}
				if((year%400>=0 && year%400<=24) || (year%400>=125 && year%400<=160) || (year%400>=249 && year%400<=284) || (year%400>=389 && year%400<=399)){
					if(year%4 == 1 || year%4 == 2){
						if(day<5) return 0;
						else return 8;
					}
					else if(day<6) return 0;
					else return 8;
				}
				if((year%400>=25 && year%400<=56) || (year%400>=161 && year%400<=192) || (year%400>=285 && year%400<=300)){
					if(year%4 == 0){
						if(day<6) return 0;
						else return 8;
					}
					else if(day<5) return 0;
					else return 8;
				}
				else if(day<5) return 0;
				else return 8;
			}
			if(month==2){
				if((year%400>=21 && year%400<=56) || (year%400>=157 && year%400<=192) || (year%400>=285 && year%400<=300)){
					if(year%4 == 1){
						if(day<3) return 8;
						else return 7;
					}
					else if(day<4) return 8;
					else return 7;
				}
				if((year%400>=57 && year%400<=88) || (year%400>=193 && year%400<=200)){
					if(year%4 == 1 || year%4 == 2){
						if(day<3) return 8;
						else return 7;
					}
					else if(day<4) return 8;
					else return 7;
				}
				if(year%400>=89 && year%400<=100){
					if(year%4 == 0){
						if(day<4) return 8;
						else return 7;
					}
					else if(day<3) return 8;
					else return 7;
				}
				if(year%400>=301 && year%400<=316){
					if(year%4 == 1){
						if(day<4) return 8;
						else return 7;
					}
					else if(day<5) return 8;
					else return 7;
				}
				if((year%400>=201 && year%400<=216) || (year%400>=317 && year%400<=352)){
					if(year%4 == 1 || year%4 == 2){
						if(day<4) return 8;
						else return 7;
					}
					else if(day<5) return 8;
					else return 7;
				}
				if((year%400>=101 && year%400<=120) || (year%400>=217 && year%400<=248) || (year%400>=353 && year%400<=384)){
					if(year%4 == 0){
						if(day<5) return 8;
						else return 7;
					}
					else if(day<4) return 8;
					else return 7;
				}
				else if(day<4) return 8;
				else return 7;
			}
			if(month==3){
				if(year%400>=88 && year%400<=99){
					if(year%4 == 0){
						if(day<4) return 7;
						else return 6;
					}
					else if(day<5) return 7;
					else return 6;
				}
				if(year%400>=300 && year%400<=319){
					if(year%4 == 3){
						if(day<7) return 7;
						else return 6;
					}
					else if(day<6) return 7;
					else return 6;
				}
				if((year%400>=200 && year%400<=223) || (year%400>=320 && year%400<=355)){
					if(day<6) return 7;
					else return 6;
				}
				if((year%400>=100 && year%400<=119) || (year%400>=224 && year%400<=255) || (year%400>=356 && year%400<=387)){
					if(year%4 == 0){
						if(day<5) return 7;
						else return 6;
					}
					else if(day<6) return 7;
					else return 6;
				}
				if((year%400>=0 && year%400<=19) || (year%400>=120 && year%400<=155) || (year%400>=256 && year%400<=287) || (year%400>=388 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 7;
						else return 6;
					}
					else if(day<6) return 7;
					else return 6;
				}
				if((year%400>=20 && year%400<=51) || (year%400>=156 && year%400<=183) || (year%400>=288 && year%400<=299)){
					if(year%4 == 3){
						if(day<6) return 7;
						else return 6;
					}
					else if(day<5) return 7;
					else return 6;
				}
				else if(day<5) return 7;
				return 6;
			}
			if(month==4){
				if((year%400>=0 && year%400<=15) || (year%400>=112 && year%400<=139) || (year%400>=256 && year%400<=283) || (year%400>=384 && year%400<=399)){
					if(year%4 == 0){
						if(day<4) return 6;
						else return 5;
					}
					else if(day<5) return 6;
					else return 5;
				}
				if((year%400>=16 && year%400<=43) || (year%400>=140 && year%400<=171) || (year%400>=284 && year%400<=299)){
					if(year%4 == 0 || year%4 == 1){
						if(day<4) return 6;
						else return 5;
					}
					else if(day<5) return 6;
					else return 5;
				}
				if((year%400>=44 && year%400<=75) || (year%400>=172 && year%400<=199)){
					if(year%4 == 3){
						if(day<5) return 6;
						else return 5;
					}
					else if(day<4) return 6;
					else return 5;
				}
				if(year%400>=76 && year%400<=99){
					if(day<4) return 6;
					else return 5;
				}
				if(year%400>=300 && year%400<=315){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 6;
						else return 5;
					}
					else if(day<6) return 6;
					else return 5;
				}
				if((year%400>=200 && year%400<=219) || (year%400>=316 && year%400<=347)){
					if(year%4 == 3){
						if(day<6) return 6;
						else return 5;
					}
					else if(day<5) return 6;
					else return 5;
				}
				else if(day<5) return 6;
				return 5;
			}
			if(month==5){
				if((year%400>=72 && year%400<=99) || (year%400>=196 && year%400<=199)){
					if(year%4 == 0){
						if(day<4) return 5;
						else return 4;
					}
					else if(day<5) return 5;
					else return 4;
				}
				if(year%400>=300 && year%400<=315){
					if(year%4 == 3){
						if(day<7) return 5;
						else return 4;
					}
					else if(day<6) return 5;
					else return 4;
				}
				if((year%400>=200 && year%400<=223) || (year%400>=316 && year%400<=347)){
					if(day<6) return 5;
					else return 4;
				}
				if((year%400>=100 && year%400<=103) || (year%400>=224 && year%400<=255) || (year%400>=348 && year%400<=379)){
					if(year%4 == 0){
						if(day<5) return 5;
						else return 4;
					}
					else if(day<6) return 5;
					else return 4;
				}
				if((year%400>=0 && year%400<=7) || (year%400>=104 && year%400<=131) || (year%400>=256 && year%400<=283) || (year%400>=380 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 5;
						else return 4;
					}
					else if(day<6) return 5;
					else return 4;
				}
				if((year%400>=8 && year%400<=39) || (year%400>=132 && year%400<=159) || (year%400>=284 && year%400<=299)){
					if(year%4 == 3){
						if(day<6) return 5;
						else return 4;
					}
					else if(day<5) return 5;
					else return 4;
				}
				else if(day<5) return 5;
				return 4;
			}
			if(month==6){
				if(year%400>=92 && year%400<=99){
					if(year%4 == 0){
						if(day<4) return 4;
						else return 3;
					}
					else if(day<5) return 4;
					else return 3;
				}
				if(year%400>=300 && year%400<=307){
					if(year%4 == 0 || year%4 == 1){
						if(day<6) return 4;
						else return 3;
					}
					else if(day<7) return 4;
					else return 3;
				}
				if((year%400>=200 && year%400<=215) || (year%400>=308 && year%400<=335)){
					if(year%4 == 3){
						if(day<7) return 4;
						else return 3;
					}
					else if(day<6) return 4;
					else return 3;
				}
				if((year%400>=216 && year%400<=251) || (year%400>=336 && year%400<=371)){
					if(day<6) return 4;
					else return 3;
				}
				if((year%400>=100 && year%400<=119) || (year%400>=252 && year%400<=279) || (year%400>=372 && year%400<=387)){
					if(year%4 == 0){
						if(day<5) return 4;
						else return 3;
					}
					else if(day<6) return 4;
					else return 3;
				}
				if((year%400>=0 && year%400<=27) || (year%400>=120 && year%400<=147) || (year%400>=280 && year%400<=299) || (year%400>=388 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 4;
						else return 3;
					}
					else if(day<6) return 4;
					else return 3;
				}
				if((year%400>=28 && year%400<=59) || (year%400>=148 && year%400<=179)){
					if(year%4 == 3){
						if(day<6) return 4;
						else return 3;
					}
					else if(day<5) return 4;
					else return 3;
				}
				else if(day<5) return 4;
				return 3;
			}
			if(month==7){
				if((year%400>=24 && year%400<=51) || (year%400>=140 && year%400<=171)){
					if(year%4 == 0){
						if(day<6) return 3;
						else return 2;
					}
					else if(day<7) return 3;
					else return 2;
				}
				if((year%400>=52 && year%400<=79) || (year%400>=172 && year%400<=195)){
					if(year%4 == 0 || year%4 == 1){
						if(day<6) return 3;
						else return 2;
					}
					else if(day<7) return 3;
					else return 2;
				}
				if((year%400>=80 && year%400<=99) || (year%400>=196 && year%400<=199)){
					if(year%4 == 3){
						if(day<7) return 3;
						else return 2;
					}
					else if(day<6) return 3;
					else return 2;
				}
				if(year%400>=300 && year%400<=303){
					if(day<8) return 3;
					else return 2;
				}
				if((year%400>=200 && year%400<=211) || (year%400>=304 && year%400<=331)){
					if(year%4 == 0){
						if(day<7) return 3;
						else return 2;
					}
					else if(day<8) return 3;
					else return 2;
				}
				if((year%400>=212 && year%400<=239) || (year%400>=332 && year%400<=359)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 3;
						else return 2;
					}
					else if(day<8) return 3;
					else return 2;
				}
				if((year%400>=100 && year%400<=107) || (year%400>=240 && year%400<=271) || (year%400>=360 && year%400<=387)){
					if(year%4 == 3){
						if(day<8) return 3;
						else return 2;
					}
					else if(day<7) return 3;
					else return 2;
				}
				else if(day<7) return 3;
				return 2;
			}
			if(month==8){
				if((year%400>=72 && year%400<=99) || (year%400>=192 && year%400<=199)){
					if(year%4 == 0){
						if(day<6) return 2;
						else return 1;
					}
					else if(day<7) return 2;
					else return 1;
				}
				if(year%400>=300 && year%400<=315){
					if(year%4 == 3){
						if(day<9) return 2;
						else return 1;
					}
					else if(day<8) return 2;
					else return 1;
				}
				if((year%400>=200 && year%400<=231) || (year%400>=316 && year%400<=351)){
					if(day<8) return 2;
					else return 1;
				}
				if((year%400>=232 && year%400<=259) || (year%400>=352 && year%400<=379)){
					if(year%4 == 0){
						if(day<7) return 2;
						else return 1;
					}
					else if(day<8) return 2;
					else return 1;
				}
				if((year%400>=0 && year%400<=7) || (year%400>=100 && year%400<=127) || (year%400>=260 && year%400<=291) || (year%400>=380 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 2;
						else return 1;
					}
					else if(day<8) return 2;
					else return 1;
				}
				if((year%400>=8 && year%400<=39) || (year%400>=128 && year%400<=159) || (year%400>=292 && year%400<=299)){
					if(year%4 == 3){
						if(day<8) return 2;
						else return 1;
					}
					else if(day<7) return 2;
					else return 1;
				}
				else if(day<7) return 2;
				return 1;
			}
			if(month==9){
				if(year%400>=88 && year%400<=99){
					if(year%4 == 0){
						if(day<6) return 1;
						else return 0;
					}
					else if(day<7) return 1;
					else return 0;
				}
				if((year%400>=200 && year%400<=207) || (year%400>=300 && year%400<=331)){
					if(year%4 == 3){
						if(day<9) return 1;
						else return 0;
					}
					else if(day<8) return 1;
					else return 0;
				}
				if((year%400>=208 && year%400<=239) || (year%400>=332 && year%400<=363)){
					if(day<8) return 1;
					else return 0;
				}
				if((year%400>=100 && year%400<=115) || (year%400>=240 && year%400<=271) || (year%400>=364 && year%400<=395)){
					if(year%4 == 0){
						if(day<7) return 1;
						else return 0;
					}
					else if(day<8) return 1;
					else return 0;
				}
				if((year%400>=0 && year%400<=23) || (year%400>=116 && year%400<=147) || (year%400>=272 && year%400<=299) || (year%400>=396 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 1;
						else return 0;
					}
					else if(day<8) return 1;
					else return 0;
				}
				if((year%400>=24 && year%400<=55) || (year%400>=148 && year%400<=175)){
					if(year%4 == 3){
						if(day<8) return 1;
						else return 0;
					}
					else if(day<7) return 1;
					else return 0;
				}
				else if(day<7) return 1;
				return 0;
			}
			if(month==10){
				if((year%400>=48 && year%400<=79) || (year%400>=176 && year%400<=199)){
					if(year%4 == 0){
						if(day<7) return 0;
						else return 8;
					}
					else if(day<8) return 0;
					else return 8;
				}
				if(year%400>=80 && year%400<=99){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 0;
						else return 8;
					}
					else if(day<8) return 0;
					else return 8;
				}
				if(year%400>=300 && year%400<=319){
					if(day<9) return 0;
					else return 8;
				}
				if((year%400>=200 && year%400<=223) || (year%400>=320 && year%400<=351)){
					if(year%4 == 0){
						if(day<8) return 0;
						else return 8;
					}
					else if(day<9) return 0;
					else return 8;
				}
				if((year%400>=100 && year%400<=107) || (year%400>=224 && year%400<=251) || (year%400>=352 && year%400<=383)){
					if(year%4 == 0 || year%4 == 1){
						if(day<8) return 0;
						else return 8;
					}
					else if(day<9) return 0;
					else return 8;
				}
				if((year%400>=0 && year%400<=11) || (year%400>=108 && year%400<=139) || (year%400>=252 && year%400<=283) || (year%400>=384 && year%400<=399)){
					if(year%4 == 3){
						if(day<9) return 0;
						else return 8;
					}
					else if(day<8) return 0;
					else return 8;
				}
				else if(day<8) return 0;
				return 8;
			}
			if(month==11){
				if((year%400>=68 && year%400<=99) || (year%400>=196 && year%400<=199)){
					if(year%4 == 0){
						if(day<6) return 8;
						else return 7;
					}
					else if(day<7) return 8;
					else return 7;
				}
				if(year%400>=300 && year%400<=331){
					if(day<8) return 8;
					else return 7;
				}
				if((year%400>=200 && year%400<=231) || (year%400>=332 && year%400<=367)){
					if(year%4 == 0){
						if(day<7) return 8;
						else return 7;
					}
					else if(day<8) return 8;
					else return 7;
				}
				if((year%400>=100 && year%400<=131) || (year%400>=232 && year%400<=263) || (year%400>=368 && year%400<=387)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 8;
						else return 7;
					}
					else if(day<8) return 8;
					else return 7;
				}
				if((year%400>=0 && year%400<=31) || (year%400>=132 && year%400<=163) || (year%400>=264 && year%400<=295) || (year%400>=388 && year%400<=399)){
					if(year%4 == 3){
						if(day<8) return 8;
						else return 7;
					}
					else if(day<7) return 8;
					else return 7;
				}
				else if(day<7) return 8;
				return 7;
			}
			if(month==12){
				if((year%400>=28 && year%400<=59) || (year%400>=164 && year%400<=195) || (year%400>=292 && year%400<=299)){
					if(year%4 == 0){
						if(day<6) return 7;
						else return 6;
					}
					else if(day<7) return 7;
					else return 6;
				}
				if((year%400>=60 && year%400<=95) || (year%400>=196 && year%400<=199)){
					if(year%4 == 0 || year%4 == 1){
						if(day<6) return 7;
						else return 6;
					}
					else if(day<7) return 7;
					else return 6;
				}
				if(year%400>=96 && year%400<=99){
					if(year%4 == 3){
						if(day<7) return 7;
						else return 6;
					}
					else if(day<6) return 7;
					else return 6;
				}
				if(year%400>=300 && year%400<=323){
					if(year%4 == 0){
						if(day<7) return 7;
						else return 6;
					}
					else if(day<8) return 7;
					else return 6;
				}
				if((year%400>=200 && year%400<=219) || (year%400>=324 && year%400<=355)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 7;
						else return 6;
					}
					else if(day<8) return 7;
					else return 6;
				}
				if((year%400>=100 && year%400<=127) || (year%400>=220 && year%400<=255) || (year%400>=356 && year%400<=387)){
					if(year%4 == 3){
						if(day<8) return 7;
						else return 6;
					}
					else if(day<7) return 7;
					else return 6;
				}
				else if(day<7) return 7;
				return 6;
			}
			else return (18-month)%9;
		}
		else if(year%3 == 2){
			if(month==1){
				if(year%400>=93 && year%400<=100){
					if(year%4 == 1){
						if(day<4) return 6;
						else return 5;
					}
					else if(day<5) return 6;
					else return 5;
				}
				if(year%400>=301 && year%400<=316){
					if(year%4 == 0){
						if(day<7) return 6;
						else return 5;
					}
					else if(day<6) return 6;
					else return 5;
				}
				if((year%400>=201 && year%400<=216) || (year%400>=317 && year%400<=356)){
					if(day<6) return 6;
					else return 5;
				}
				if((year%400>=101 && year%400<=124) || (year%400>=217 && year%400<=248) || (year%400>=357 && year%400<=388)){
					if(year%4 == 1){
						if(day<5) return 6;
						else return 5;
					}
					else if(day<6) return 6;
					else return 5;
				}
				if((year%400>=0 && year%400<=24) || (year%400>=125 && year%400<=160) || (year%400>=249 && year%400<=284) || (year%400>=389 && year%400<=399)){
					if(year%4 == 1 || year%4 == 2){
						if(day<5) return 6;
						else return 5;
					}
					else if(day<6) return 6;
					else return 5;
				}
				if((year%400>=25 && year%400<=56) || (year%400>=161 && year%400<=192) || (year%400>=285 && year%400<=300)){
					if(year%4 == 0){
						if(day<6) return 6;
						else return 5;
					}
					else if(day<5) return 6;
					else return 5;
				}
				else if(day<5) return 6;
				else return 5;
			}
			if(month==2){
				if((year%400>=21 && year%400<=56) || (year%400>=157 && year%400<=192) || (year%400>=285 && year%400<=300)){
					if(year%4 == 1){
						if(day<3) return 5;
						else return 4;
					}
					else if(day<4) return 5;
					else return 4;
				}
				if((year%400>=57 && year%400<=88) || (year%400>=193 && year%400<=200)){
					if(year%4 == 1 || year%4 == 2){
						if(day<3) return 5;
						else return 4;
					}
					else if(day<4) return 5;
					else return 4;
				}
				if(year%400>=89 && year%400<=100){
					if(year%4 == 0){
						if(day<4) return 5;
						else return 4;
					}
					else if(day<3) return 5;
					else return 4;
				}
				if(year%400>=301 && year%400<=316){
					if(year%4 == 1){
						if(day<4) return 5;
						else return 4;
					}
					else if(day<5) return 5;
					else return 4;
				}
				if((year%400>=201 && year%400<=216) || (year%400>=317 && year%400<=352)){
					if(year%4 == 1 || year%4 == 2){
						if(day<4) return 5;
						else return 4;
					}
					else if(day<5) return 5;
					else return 4;
				}
				if((year%400>=101 && year%400<=120) || (year%400>=217 && year%400<=248) || (year%400>=353 && year%400<=384)){
					if(year%4 == 0){
						if(day<5) return 5;
						else return 4;
					}
					else if(day<4) return 5;
					else return 4;
				}
				else if(day<4) return 5;
				else return 4;
			}
			if(month==3){
				if(year%400>=88 && year%400<=99){
					if(year%4 == 0){
						if(day<4) return 4;
						else return 3;
					}
					else if(day<5) return 4;
					else return 3;
				}
				if(year%400>=300 && year%400<=319){
					if(year%4 == 3){
						if(day<7) return 4;
						else return 3;
					}
					else if(day<6) return 4;
					else return 3;
				}
				if((year%400>=200 && year%400<=223) || (year%400>=320 && year%400<=355)){
					if(day<6) return 4;
					else return 3;
				}
				if((year%400>=100 && year%400<=119) || (year%400>=224 && year%400<=255) || (year%400>=356 && year%400<=387)){
					if(year%4 == 0){
						if(day<5) return 4;
						else return 3;
					}
					else if(day<6) return 4;
					else return 3;
				}
				if((year%400>=0 && year%400<=19) || (year%400>=120 && year%400<=155) || (year%400>=256 && year%400<=287) || (year%400>=388 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 4;
						else return 3;
					}
					else if(day<6) return 4;
					else return 3;
				}
				if((year%400>=20 && year%400<=51) || (year%400>=156 && year%400<=183) || (year%400>=288 && year%400<=299)){
					if(year%4 == 3){
						if(day<6) return 4;
						else return 3;
					}
					else if(day<5) return 4;
					else return 3;
				}
				else if(day<5) return 4;
				return 3;
			}
			if(month==4){
				if((year%400>=0 && year%400<=15) || (year%400>=112 && year%400<=139) || (year%400>=256 && year%400<=283) || (year%400>=384 && year%400<=399)){
					if(year%4 == 0){
						if(day<4) return 3;
						else return 2;
					}
					else if(day<5) return 3;
					else return 2;
				}
				if((year%400>=16 && year%400<=43) || (year%400>=140 && year%400<=171) || (year%400>=284 && year%400<=299)){
					if(year%4 == 0 || year%4 == 1){
						if(day<4) return 3;
						else return 2;
					}
					else if(day<5) return 3;
					else return 2;
				}
				if((year%400>=44 && year%400<=75) || (year%400>=172 && year%400<=199)){
					if(year%4 == 3){
						if(day<5) return 3;
						else return 2;
					}
					else if(day<4) return 3;
					else return 2;
				}
				if(year%400>=76 && year%400<=99){
					if(day<4) return 3;
					else return 2;
				}
				if(year%400>=300 && year%400<=315){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 3;
						else return 2;
					}
					else if(day<6) return 3;
					else return 2;
				}
				if((year%400>=200 && year%400<=219) || (year%400>=316 && year%400<=347)){
					if(year%4 == 3){
						if(day<6) return 3;
						else return 2;
					}
					else if(day<5) return 3;
					else return 2;
				}
				else if(day<5) return 3;
				return 2;
			}
			if(month==5){
				if((year%400>=72 && year%400<=99) || (year%400>=196 && year%400<=199)){
					if(year%4 == 0){
						if(day<4) return 2;
						else return 1;
					}
					else if(day<5) return 2;
					else return 1;
				}
				if(year%400>=300 && year%400<=315){
					if(year%4 == 3){
						if(day<7) return 2;
						else return 1;
					}
					else if(day<6) return 2;
					else return 1;
				}
				if((year%400>=200 && year%400<=223) || (year%400>=316 && year%400<=347)){
					if(day<6) return 2;
					else return 1;
				}
				if((year%400>=100 && year%400<=103) || (year%400>=224 && year%400<=255) || (year%400>=348 && year%400<=379)){
					if(year%4 == 0){
						if(day<5) return 2;
						else return 1;
					}
					else if(day<6) return 2;
					else return 1;
				}
				if((year%400>=0 && year%400<=7) || (year%400>=104 && year%400<=131) || (year%400>=256 && year%400<=283) || (year%400>=380 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 2;
						else return 1;
					}
					else if(day<6) return 2;
					else return 1;
				}
				if((year%400>=8 && year%400<=39) || (year%400>=132 && year%400<=159) || (year%400>=284 && year%400<=299)){
					if(year%4 == 3){
						if(day<6) return 2;
						else return 1;
					}
					else if(day<5) return 2;
					else return 1;
				}
				else if(day<5) return 2;
				return 1;
			}
			if(month==6){
				if(year%400>=92 && year%400<=99){
					if(year%4 == 0){
						if(day<4) return 1;
						else return 0;
					}
					else if(day<5) return 1;
					else return 0;
				}
				if(year%400>=300 && year%400<=307){
					if(year%4 == 0 || year%4 == 1){
						if(day<6) return 1;
						else return 0;
					}
					else if(day<7) return 1;
					else return 0;
				}
				if((year%400>=200 && year%400<=215) || (year%400>=308 && year%400<=335)){
					if(year%4 == 3){
						if(day<7) return 1;
						else return 0;
					}
					else if(day<6) return 1;
					else return 0;
				}
				if((year%400>=216 && year%400<=251) || (year%400>=336 && year%400<=371)){
					if(day<6) return 1;
					else return 0;
				}
				if((year%400>=100 && year%400<=119) || (year%400>=252 && year%400<=279) || (year%400>=372 && year%400<=387)){
					if(year%4 == 0){
						if(day<5) return 1;
						else return 0;
					}
					else if(day<6) return 1;
					else return 0;
				}
				if((year%400>=0 && year%400<=27) || (year%400>=120 && year%400<=147) || (year%400>=280 && year%400<=299) || (year%400>=388 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<5) return 1;
						else return 0;
					}
					else if(day<6) return 1;
					else return 0;
				}
				if((year%400>=28 && year%400<=59) || (year%400>=148 && year%400<=179)){
					if(year%4 == 3){
						if(day<6) return 1;
						else return 0;
					}
					else if(day<5) return 1;
					else return 0;
				}
				else if(day<5) return 1;
				return 0;
			}
			if(month==7){
				if((year%400>=24 && year%400<=51) || (year%400>=140 && year%400<=171)){
					if(year%4 == 0){
						if(day<6) return 0;
						else return 8;
					}
					else if(day<7) return 0;
					else return 8;
				}
				if((year%400>=52 && year%400<=79) || (year%400>=172 && year%400<=195)){
					if(year%4 == 0 || year%4 == 1){
						if(day<6) return 0;
						else return 8;
					}
					else if(day<7) return 0;
					else return 8;
				}
				if((year%400>=80 && year%400<=99) || (year%400>=196 && year%400<=199)){
					if(year%4 == 3){
						if(day<7) return 0;
						else return 8;
					}
					else if(day<6) return 0;
					else return 8;
				}
				if(year%400>=300 && year%400<=303){
					if(day<8) return 0;
					else return 8;
				}
				if((year%400>=200 && year%400<=211) || (year%400>=304 && year%400<=331)){
					if(year%4 == 0){
						if(day<7) return 0;
						else return 8;
					}
					else if(day<8) return 0;
					else return 8;
				}
				if((year%400>=212 && year%400<=239) || (year%400>=332 && year%400<=359)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 0;
						else return 8;
					}
					else if(day<8) return 0;
					else return 8;
				}
				if((year%400>=100 && year%400<=107) || (year%400>=240 && year%400<=271) || (year%400>=360 && year%400<=387)){
					if(year%4 == 3){
						if(day<8) return 0;
						else return 8;
					}
					else if(day<7) return 0;
					else return 8;
				}
				else if(day<7) return 0;
				return 8;
			}
			if(month==8){
				if((year%400>=72 && year%400<=99) || (year%400>=192 && year%400<=199)){
					if(year%4 == 0){
						if(day<6) return 8;
						else return 7;
					}
					else if(day<7) return 8;
					else return 7;
				}
				if(year%400>=300 && year%400<=315){
					if(year%4 == 3){
						if(day<9) return 8;
						else return 7;
					}
					else if(day<8) return 8;
					else return 7;
				}
				if((year%400>=200 && year%400<=231) || (year%400>=316 && year%400<=351)){
					if(day<8) return 8;
					else return 7;
				}
				if((year%400>=232 && year%400<=259) || (year%400>=352 && year%400<=379)){
					if(year%4 == 0){
						if(day<7) return 8;
						else return 7;
					}
					else if(day<8) return 8;
					else return 7;
				}
				if((year%400>=0 && year%400<=7) || (year%400>=100 && year%400<=127) || (year%400>=260 && year%400<=291) || (year%400>=380 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 8;
						else return 7;
					}
					else if(day<8) return 8;
					else return 7;
				}
				if((year%400>=8 && year%400<=39) || (year%400>=128 && year%400<=159) || (year%400>=292 && year%400<=299)){
					if(year%4 == 3){
						if(day<8) return 8;
						else return 7;
					}
					else if(day<7) return 8;
					else return 7;
				}
				else if(day<7) return 8;
				return 7;
			}
			if(month==9){
				if(year%400>=88 && year%400<=99){
					if(year%4 == 0){
						if(day<6) return 7;
						else return 6;
					}
					else if(day<7) return 7;
					else return 6;
				}
				if((year%400>=200 && year%400<=207) || (year%400>=300 && year%400<=331)){
					if(year%4 == 3){
						if(day<9) return 7;
						else return 6;
					}
					else if(day<8) return 7;
					else return 6;
				}
				if((year%400>=208 && year%400<=239) || (year%400>=332 && year%400<=363)){
					if(day<8) return 7;
					else return 6;
				}
				if((year%400>=100 && year%400<=115) || (year%400>=240 && year%400<=271) || (year%400>=364 && year%400<=395)){
					if(year%4 == 0){
						if(day<7) return 7;
						else return 6;
					}
					else if(day<8) return 7;
					else return 6;
				}
				if((year%400>=0 && year%400<=23) || (year%400>=116 && year%400<=147) || (year%400>=272 && year%400<=299) || (year%400>=396 && year%400<=399)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 7;
						else return 6;
					}
					else if(day<8) return 7;
					else return 6;
				}
				if((year%400>=24 && year%400<=55) || (year%400>=148 && year%400<=175)){
					if(year%4 == 3){
						if(day<8) return 7;
						else return 6;
					}
					else if(day<7) return 7;
					else return 6;
				}
				else if(day<7) return 7;
				return 6;
			}
			if(month==10){
				if((year%400>=48 && year%400<=79) || (year%400>=176 && year%400<=199)){
					if(year%4 == 0){
						if(day<7) return 6;
						else return 5;
					}
					else if(day<8) return 6;
					else return 5;
				}
				if(year%400>=80 && year%400<=99){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 6;
						else return 5;
					}
					else if(day<8) return 6;
					else return 5;
				}
				if(year%400>=300 && year%400<=319){
					if(day<9) return 6;
					else return 5;
				}
				if((year%400>=200 && year%400<=223) || (year%400>=320 && year%400<=351)){
					if(year%4 == 0){
						if(day<8) return 6;
						else return 5;
					}
					else if(day<9) return 6;
					else return 5;
				}
				if((year%400>=100 && year%400<=107) || (year%400>=224 && year%400<=251) || (year%400>=352 && year%400<=383)){
					if(year%4 == 0 || year%4 == 1){
						if(day<8) return 6;
						else return 5;
					}
					else if(day<9) return 6;
					else return 5;
				}
				if((year%400>=0 && year%400<=11) || (year%400>=108 && year%400<=139) || (year%400>=252 && year%400<=283) || (year%400>=384 && year%400<=399)){
					if(year%4 == 3){
						if(day<9) return 6;
						else return 5;
					}
					else if(day<8) return 6;
					else return 5;
				}
				else if(day<8) return 6;
				return 5;
			}
			if(month==11){
				if((year%400>=68 && year%400<=99) || (year%400>=196 && year%400<=199)){
					if(year%4 == 0){
						if(day<6) return 5;
						else return 4;
					}
					else if(day<7) return 5;
					else return 4;
				}
				if(year%400>=300 && year%400<=331){
					if(day<8) return 5;
					else return 4;
				}
				if((year%400>=200 && year%400<=231) || (year%400>=332 && year%400<=367)){
					if(year%4 == 0){
						if(day<7) return 5;
						else return 4;
					}
					else if(day<8) return 5;
					else return 4;
				}
				if((year%400>=100 && year%400<=131) || (year%400>=232 && year%400<=263) || (year%400>=368 && year%400<=387)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 5;
						else return 4;
					}
					else if(day<8) return 5;
					else return 4;
				}
				if((year%400>=0 && year%400<=31) || (year%400>=132 && year%400<=163) || (year%400>=264 && year%400<=295) || (year%400>=388 && year%400<=399)){
					if(year%4 == 3){
						if(day<8) return 5;
						else return 4;
					}
					else if(day<7) return 5;
					else return 4;
				}
				else if(day<7) return 5;
				return 4;
			}
			if(month==12){
				if((year%400>=28 && year%400<=59) || (year%400>=164 && year%400<=195) || (year%400>=292 && year%400<=299)){
					if(year%4 == 0){
						if(day<6) return 4;
						else return 3;
					}
					else if(day<7) return 4;
					else return 3;
				}
				if((year%400>=60 && year%400<=95) || (year%400>=196 && year%400<=199)){
					if(year%4 == 0 || year%4 == 1){
						if(day<6) return 4;
						else return 3;
					}
					else if(day<7) return 4;
					else return 3;
				}
				if(year%400>=96 && year%400<=99){
					if(year%4 == 3){
						if(day<7) return 4;
						else return 3;
					}
					else if(day<6) return 4;
					else return 3;
				}
				if(year%400>=300 && year%400<=323){
					if(year%4 == 0){
						if(day<7) return 4;
						else return 3;
					}
					else if(day<8) return 4;
					else return 3;
				}
				if((year%400>=200 && year%400<=219) || (year%400>=324 && year%400<=355)){
					if(year%4 == 0 || year%4 == 1){
						if(day<7) return 4;
						else return 3;
					}
					else if(day<8) return 4;
					else return 3;
				}
				if((year%400>=100 && year%400<=127) || (year%400>=220 && year%400<=255) || (year%400>=356 && year%400<=387)){
					if(year%4 == 3){
						if(day<8) return 4;
						else return 3;
					}
					else if(day<7) return 4;
					else return 3;
				}
				else if(day<7) return 4;
				return 3;
			}
			else return (15-month)%9;
		}
		else return month%9;
	}

	public int nineDay(){
		int cal = calenderId(day1);
		if((cal%175680>=0 && cal%175680<785) || (cal%175680>=21845 && cal%175680<25985) || (cal%175680>=46865 && cal%175680<51005) || (cal%175680>=71885 && cal%175680<76025) || (cal%175680>=97085 && cal%175680<101225) || (cal%175680>=122105 && cal%175680<126245) || (cal%175680>=147305 && cal%175680<151445) || (cal%175680>=172325 && cal%175680<175680)){
			if((cal+115)%360<180) return (cal+7)%9;
			else{
				if(cal%9 <= 1) return 1-cal%9;
				else return 10-cal%9;
			}
		}
		if((cal%175680>=9245 && cal%175680<13385) || (cal%175680>=34265 && cal%175680<38405) || (cal%175680>=59465 && cal%175680<63605) || (cal%175680>=84485 && cal%175680<88625) || (cal%175680>=109685 && cal%175680<113825) || (cal%175680>=134705 && cal%175680<138845) || (cal%175680>=159725 && cal%175680<163865)){
			if((cal+295)%360<180) return (cal+7)%9;
			else{
				if(cal%9 <= 1) return 1-cal%9;
				else return 10-cal%9;
			}
		}
		if((cal%175680>=785 && cal%175680<815) || (cal%175680>=25985 && cal%175680<26015) || (cal%175680>=38405 && cal%175680<38435) || (cal%175680>=63605 && cal%175680<63635) || (cal%175680>=76025 && cal%175680<76055) || (cal%175680>=101225 && cal%175680<101255) || (cal%175680>=138845 && cal%175680<138875)){
			return (cal+7)%9;
		}
		if((cal%175680>=815 && cal%175680<845) || (cal%175680>=26015 && cal%175680<26045) || (cal%175680>=38435 && cal%175680<38465) || (cal%175680>=63635 && cal%175680<63665) || (cal%175680>=76055 && cal%175680<76085) || (cal%175680>=101255 && cal%175680<101285) || (cal%175680>=138875 && cal%175680<138905)){
			if(cal%9 == 8) return 8;
			else return 7-cal%9;
		}
		if((cal%175680>=13385 && cal%175680<13415) || (cal%175680>=51005 && cal%175680<51035) || (cal%175680>=88625 && cal%175680<88655) || (cal%175680>=113825 && cal%175680<113855) || (cal%175680>=126245 && cal%175680<126275) || (cal%175680>=151445 && cal%175680<151475) || (cal%175680>=163865 && cal%175680<163895)){
			if(cal%9 <= 1) return 1-cal%9;
			else return 10-cal%9;
		}
		if((cal%175680>=13415 && cal%175680<13445) || (cal%175680>=51035 && cal%175680<51065) || (cal%175680>=88655 && cal%175680<88685) || (cal%175680>=113855 && cal%175680<113885) || (cal%175680>=126275 && cal%175680<126305) || (cal%175680>=151475 && cal%175680<151505) || (cal%175680>=163895 && cal%175680<163925)){
			return (cal+1)%9;
		}
		if((cal%175680>=845 && cal%175680<4985) || (cal%175680>=26045 && cal%175680<30185) || (cal%175680>=51065 && cal%175680<55205) || (cal%175680>=76085 && cal%175680<80225) || (cal%175680>=101285 && cal%175680<105425) || (cal%175680>=126305 && cal%175680<130445) || (cal%175680>=151505 && cal%175680<155645)){
			if((cal+55)%360<180) return (cal+1)%9;
			else{
				if(cal%9 == 8) return 8;
				else return 7-cal%9;
			}
		}
		if((cal%175680>=13445 && cal%175680<17585) || (cal%175680>=38465 && cal%175680<42605) || (cal%175680>=63665 && cal%175680<67805) || (cal%175680>=88685 && cal%175680<92825) || (cal%175680>=113885 && cal%175680<117845) || (cal%175680>=138905 && cal%175680<143045) || (cal%175680>=163925 && cal%175680<168065)){
			if((cal+235)%360<180) return (cal+1)%9;
			else{
				if(cal%9 == 8) return 8;
				else return 7-cal%9;
			}
		}
		if((cal%175680>=4985 && cal%175680<5015) || (cal%175680>=30185 && cal%175680<30215) || (cal%175680>=42605 && cal%175680<42635) || (cal%175680>=67805 && cal%175680<67835) || (cal%175680>=80225 && cal%175680<80255) || (cal%175680>=105425 && cal%175680<105455) || (cal%175680>=117845 && cal%175680<117875) || (cal%175680>=143045 && cal%175680<143075)){
			if(cal%9 == 8) return 8;
			else return 7-cal%9;
		}
		if((cal%175680>=5015 && cal%175680<5045) || (cal%175680>=30215 && cal%175680<30245) || (cal%175680>=42635 && cal%175680<42665) || (cal%175680>=67835 && cal%175680<67865) || (cal%175680>=80255 && cal%175680<80285) || (cal%175680>=105455 && cal%175680<105485) || (cal%175680>=117875 && cal%175680<117905) || (cal%175680>=143075 && cal%175680<143105)){
			return (cal+4)%9;
		}
		if((cal%175680>=17585 && cal%175680<17615) || (cal%175680>=55205 && cal%175680<55235) || (cal%175680>=92825 && cal%175680<92855) || (cal%175680>=130445 && cal%175680<130475) || (cal%175680>=155645 && cal%175680<155675) || (cal%175680>=168065 && cal%175680<168095)){
			return (cal+1)%9;
		}
		if((cal%175680>=17615 && cal%175680<17645) || (cal%175680>=55235 && cal%175680<55265) || (cal%175680>=92855 && cal%175680<92885) || (cal%175680>=130475 && cal%175680<130505) || (cal%175680>=155675 && cal%175680<155705) || (cal%175680>=168095 && cal%175680<168125)){
			if(cal%9 <= 4) return 4-cal%9;
			else return 13-cal%9;
		}
		if((cal%175680>=5045 && cal%175680<9185) || (cal%175680>=30245 && cal%175680<34205) || (cal%175680>=55265 && cal%175680<59405) || (cal%175680>=80285 && cal%175680<84425) || (cal%175680>=105485 && cal%175680<109625) || (cal%175680>=130505 && cal%175680<134645) || (cal%175680>=155705 && cal%175680<159665)){
			if((cal+355)%360<180) return (cal+4)%9;
			else{
				if(cal%9 <= 4) return 4-cal%9;
				else return 13-cal%9;
			}
		}
		if((cal%175680>=17645 && cal%175680<21785) || (cal%175680>=42665 && cal%175680<46805) || (cal%175680>=67865 && cal%175680<71825) || (cal%175680>=92885 && cal%175680<97025) || (cal%175680>=117905 && cal%175680<122045) || (cal%175680>=143105 && cal%175680<147245) || (cal%175680>=168125 && cal%175680<172265)){
			if((cal+175)%360<180) return (cal+4)%9;
			else{
				if(cal%9 <= 4) return 4-cal%9;
				else return 13-cal%9;
			}
		}
		if((cal%175680>=9185 && cal%175680<9215) || (cal%175680>=46805 && cal%175680<46835) || (cal%175680>=84425 && cal%175680<84455) || (cal%175680>=109625 && cal%175680<109655) || (cal%175680>=122045 && cal%175680<122075) || (cal%175680>=147245 && cal%175680<147275) || (cal%175680>=159665 && cal%175680<159695)){
			return (cal+4)%9;
		}
		if((cal%175680>=9215 && cal%175680<9245) || (cal%175680>=46835 && cal%175680<46865) || (cal%175680>=84455 && cal%175680<84485) || (cal%175680>=109655 && cal%175680<109685) || (cal%175680>=122075 && cal%175680<122105) || (cal%175680>=147275 && cal%175680<147305) || (cal%175680>=159695 && cal%175680<159725)){
			if(cal%9 <= 1) return 1-cal%9;
			else return 10-cal%9;
		}
		if((cal%175680>=21785 && cal%175680<21815) || (cal%175680>=34205 && cal%175680<34235) || (cal%175680>=59405 && cal%175680<59435) || (cal%175680>=71825 && cal%175680<71855) || (cal%175680>=97025 && cal%175680<97055) || (cal%175680>=134645 && cal%175680<134675) || (cal%175680>=172265 && cal%175680<172295)){
			if(cal%9 <= 4) return 4-cal%9;
			else return 13-cal%9;
		}
		if((cal%175680>=21815 && cal%175680<21845) || (cal%175680>=34235 && cal%175680<34265) || (cal%175680>=59435 && cal%175680<59465) || (cal%175680>=71855 && cal%175680<71885) || (cal%175680>=97055 && cal%175680<97085) || (cal%175680>=134675 && cal%175680<134705) || (cal%175680>=172295 && cal%175680<172325)){
			return (cal+7)%9;
		}
		else return cal%9;
	}

	public int holoscope(){
		int year = day1.getYear();
		int month = day1.getMonth();
		int day = day1.getDate();
		if(month==1){
			if((year%400>=53 && year%400<=88) || (year%400>=193 && year%400<=200)){
				if(year%4 == 1){
					if(day<19) return 9;
					else return 10;
				}
				else if(day<20) return 9;
				else return 10;
			}
			if(year%400>=89 && year%400<=100){
				if(year%4 == 1 || year%4 == 2){
					if(day<19) return 9;
					else return 10;
				}
				else if(day<20) return 9;
				else return 10;
			}
			if(year%400>=301 && year%400<=316){
				if(day<21) return 9;
				else return 10;
			}
			if((year%400>=201 && year%400<=212) || (year%400>=317 && year%400<=348)){
				if(year%4 == 1){
					if(day<20) return 9;
					else return 10;
				}
				else if(day<21) return 9;
				else return 10;
			}
			if((year%400>=101 && year%400<=120) || (year%400>=213 && year%400<=244) || (year%400>=349 && year%400<=384)){
				if(year%4 == 1 || year%4 == 2){
					if(day<20) return 9;
					else return 10;
				}
				else if(day<21) return 9;
				else return 10;
			}
			if((year%400>=0 && year%400<=16) || (year%400>=121 && year%400<=156) || (year%400>=245 && year%400<=280) || (year%400>=385 && year%400<=399)){
				if(year%4 == 0){
					if(day<21) return 9;
					else return 10;
				}
				else if(day<20) return 9;
				else return 10;
			}
			else if(day<20) return 9;
			else return 10;
		}
		if(month==2){
			if((year%400>=0 && year%400<=28) || (year%400>=133 && year%400<=168) || (year%400>=261 && year%400<=296) || (year%400>=397 && year%400<=399)){
				if(year%4 == 1){
					if(day<18) return 10;
					else return 11;
				}
				else if(day<19) return 10;
				else return 11;
			}
			if((year%400>=29 && year%400<=64) || (year%400>=169 && year%400<=200) || (year%400>=297 && year%400<=300)){
				if(year%4 == 1 || year%4 == 2){
					if(day<18) return 10;
					else return 11;
				}
				else if(day<19) return 10;
				else return 11;
			}
			if(year%400>=65 && year%400<=96){
				if(year%4 == 0){
					if(day<19) return 10;
					else return 11;
				}
				else if(day<18) return 10;
				else return 11;
			}
			if(year%400>=97 && year%400<=100){
				if(day<18) return 10;
				else return 11;
			}
			if(year%400>=301 && year%400<=328){
				if(year%4 == 1 || year%4 == 2){
					if(day<19) return 10;
					else return 11;
				}
				else if(day<20) return 10;
				else return 11;
			}
			if((year%400>=201 && year%400<=224) || (year%400>=329 && year%400<=360)){
				if(year%4 == 0){
					if(day<20) return 10;
					else return 11;
				}
				else if(day<19) return 10;
				else return 11;
			}
			else if(day<19) return 10;
			else return 11;
		}
		if(month==3){
			if(year%400>=92 && year%400<=99){
				if(year%4 == 0){
					if(day<19) return 11;
					else return 0;
				}
				else if(day<20) return 11;
				else return 0;
			}
			if(year%400>=300 && year%400<=323){
				if(year%4 == 3){
					if(day<22) return 11;
					else return 0;
				}
				else if(day<21) return 11;
				else return 0;
			}
			if((year%400>=200 && year%400<=227) || (year%400>=324 && year%400<=359)){
				if(day<21) return 11;
				else return 0;
			}
			if((year%400>=100 && year%400<=123) || (year%400>=228 && year%400<=259) || (year%400>=360 && year%400<=391)){
				if(year%4 == 0){
					if(day<20) return 11;
					else return 0;
				}
				else if(day<21) return 11;
				else return 0;
			}
			if((year%400>=0 && year%400<=23) || (year%400>=124 && year%400<=155) || (year%400>=260 && year%400<=291) || (year%400>=392 && year%400<=399)){
				if(year%4 == 0 || year%4 == 1){
					if(day<20) return 11;
					else return 0;
				}
				else if(day<21) return 11;
				else return 0;
			}
			if((year%400>=24 && year%400<=55) || (year%400>=156 && year%400<=187) || (year%400>=292 && year%400<=299)){
				if(year%4 == 3){
					if(day<21) return 11;
					else return 0;
				}
				else if(day<20) return 11;
				else return 0;
			}
			else if(day<20) return 11;
			else return 0;
		}
		if(month==4){
			if((year%400>=20 && year%400<=51) || (year%400>=148 && year%400<=175) || (year%400>=296 && year%400<=299)){
				if(year%4 == 0){
					if(day<19) return 0;
					else return 1;
				}
				else if(day<20) return 0;
				else return 1;
			}
			if((year%400>=52 && year%400<=79) || (year%400>=176 && year%400<=199)){
				if(year%4 == 0 || year%4 == 1){
					if(day<19) return 0;
					else return 1;
				}
				else if(day<20) return 0;
				else return 1;
			}
			if((year%400>=80 && year%400<=99)){
				if(year%4 == 3){
					if(day<20) return 0;
					else return 1;
				}
				else if(day<19) return 0;
				else return 1;
			}
			if(year%400>=300 && year%400<=323){
				if(year%4 == 0){
					if(day<20) return 0;
					else return 1;
				}
				else if(day<21) return 0;
				else return 1;
			}
			if((year%400>=200 && year%400<=227) || (year%400>=324 && year%400<=355)){
				if(year%4 == 0 || year%4 == 1){
					if(day<20) return 0;
					else return 1;
				}
				else if(day<21) return 0;
				else return 1;
			}
			if((year%400>=100 && year%400<=111) || (year%400>=228 && year%400<=259) || (year%400>=356 && year%400<=383)){
				if(year%4 == 3){
					if(day<21) return 0;
					else return 1;
				}
				else if(day<20) return 0;
				else return 1;
			}
			else if(day<20) return 0;
			else return 1;
		}
		if(month==5){
			if((year%400>=16 && year%400<=43) || (year%400>=136 && year%400<=167) || (year%400>=292 && year%400<=299)){
				if(year%4 == 0){
					if(day<20) return 1;
					else return 2;
				}
				else if(day<21) return 1;
				else return 2;
			}
			if((year%400>=44 && year%400<=75) || (year%400>=168 && year%400<=195)){
				if(year%4 == 0 || year%4 == 1){
					if(day<20) return 1;
					else return 2;
				}
				else if(day<21) return 1;
				else return 2;
			}
			if((year%400>=76 && year%400<=99) || (year%400>=196 && year%400<=199)){
				if(year%4 == 3){
					if(day<21) return 1;
					else return 2;
				}
				else if(day<20) return 1;
				else return 2;
			}
			if(year%400>=300 && year%400<=323){
				if(year%4 == 0){
					if(day<21) return 1;
					else return 2;
				}
				else if(day<22) return 1;
				else return 2;
			}
			if((year%400>=200 && year%400<=231) || (year%400>=324 && year%400<=351)){
				if(year%4 == 0 || year%4 == 1){
					if(day<21) return 1;
					else return 2;
				}
				else if(day<22) return 1;
				else return 2;
			}
			if((year%400>=100 && year%400<=103) || (year%400>=232 && year%400<=259) || (year%400>=352 && year%400<=383)){
				if(year%4 == 3){
					if(day<22) return 1;
					else return 2;
				}
				else if(day<21) return 1;
				else return 2;
			}
			else if(day<21) return 1;
			else return 2;
		}
		if(month==6){
			if((year%400>=56 && year%400<=83) || (year%400>=176 && year%400<=199)){
				if(year%4 == 0){
					if(day<20) return 2;
					else return 3;
				}
				else if(day<21) return 2;
				else return 3;
			}
			if(year%400>=84 && year%400<=99){
				if(year%4 == 0 || year%4 == 1){
					if(day<20) return 2;
					else return 3;
				}
				else if(day<21) return 2;
				else return 3;
			}
			if(year%400>=300 && year%400<=303){
				if(year%4 == 3){
					if(day<23) return 2;
					else return 3;
				}
				else if(day<22) return 2;
				else return 3;
			}
			if((year%400>=200 && year%400<=215) || (year%400>=304 && year%400<=335)){
				if(day<22) return 2;
				else return 3;
			}
			if((year%400>=216 && year%400<=243) || (year%400>=336 && year%400<=363)){
				if(year%4 == 0){
					if(day<21) return 2;
					else return 3;
				}
				else if(day<22) return 2;
				else return 3;
			}
			if((year%400>=100 && year%400<=111) || (year%400>=244 && year%400<=275) || (year%400>=364 && year%400<=391)){
				if(year%4 == 0 || year%4 == 1){
					if(day<21) return 2;
					else return 3;
				}
				else if(day<22) return 2;
				else return 3;
			}
			if((year%400>=0 && year%400<=19) || (year%400>=112 && year%400<=139) || (year%400>=276 && year%400<=299) || (year%400>=392 && year%400<=399)){
				if(year%4 == 3){
					if(day<22) return 2;
					else return 3;
				}
				else if(day<21) return 2;
				else return 3;
			}
			else if(day<21) return 2;
			else return 3;
		}
		if(month==7){
			if((year%400>=0 && year%400<=19) || (year%400>=108 && year%400<=135) || (year%400>=272 && year%400<=299) || (year%400>=388 && year%400<=399)){
				if(year%4 == 0){
					if(day<22) return 3;
					else return 4;
				}
				else if(day<23) return 3;
				else return 4;
			}
			if((year%400>=20 && year%400<=47) || (year%400>=136 && year%400<=163)){
				if(year%4 == 0 || year%4 == 1){
					if(day<22) return 3;
					else return 4;
				}
				else if(day<23) return 3;
				else return 4;
			}
			if((year%400>=48 && year%400<=75) || (year%400>=164 && year%400<=195)){
				if(year%4 == 3){
					if(day<23) return 3;
					else return 4;
				}
				else if(day<22) return 3;
				else return 4;
			}
			if((year%400>=76 && year%400<=99) || (year%400>=196 && year%400<=199)){
				if(day<22) return 3;
				else return 4;
			}
			if((year%400>=200 && year%400<=207) || (year%400>=300 && year%400<=327)){
				if(year%4 == 0 || year%4 == 1){
					if(day<23) return 3;
					else return 4;
				}
				else if(day<24) return 3;
				else return 4;
			}
			if((year%400>=208 && year%400<=235) || (year%400>=328 && year%400<=355)){
				if(year%4 == 3){
					if(day<24) return 3;
					else return 4;
				}
				else if(day<23) return 3;
				else return 4;
			}
			else if(day<23) return 3;
			else return 4;
		}
		if(month==8){
			if((year%400>=24 && year%400<=55) || (year%400>=148 && year%400<=175)){
				if(year%4 == 0){
					if(day<22) return 4;
					else return 5;
				}
				else if(day<23) return 4;
				else return 5;
			}
			if((year%400>=56 && year%400<=83) || (year%400>=176 && year%400<=199)){
				if(year%4 == 0 || year%4 == 1){
					if(day<22) return 4;
					else return 5;
				}
				else if(day<23) return 4;
				else return 5;
			}
			if(year%400>=84 && year%400<=99){
				if(year%4 == 3){
					if(day<23) return 4;
					else return 5;
				}
				else if(day<22) return 4;
				else return 5;
			}
			if(year%400>=300 && year%400<=303){
				if(day<24) return 4;
				else return 5;
			}
			if((year%400>=200 && year%400<=211) || (year%400>=304 && year%400<=331)){
				if(year%4 == 0){
					if(day<23) return 4;
					else return 5;
				}
				else if(day<24) return 4;
				else return 5;
			}
			if((year%400>=212 && year%400<=239) || (year%400>=332 && year%400<=363)){
				if(year%4 == 0 || year%4 == 1){
					if(day<23) return 4;
					else return 5;
				}
				else if(day<24) return 4;
				else return 5;
			}
			if((year%400>=100 && year%400<=111) || (year%400>=240 && year%400<=271) || (year%400>=364 && year%400<=391)){
				if(year%4 == 3){
					if(day<24) return 4;
					else return 5;
				}
				else if(day<23) return 4;
				else return 5;
			}
			else if(day<23) return 4;
			else return 5;
		}
		if(month==9){
			if((year%400>=12 && year%400<=43) || (year%400>=140 && year%400<=167) || (year%400>=288 && year%400<=299)){
				if(year%4 == 0){
					if(day<22) return 5;
					else return 6;
				}
				else if(day<23) return 5;
				else return 6;
			}
			if((year%400>=44 && year%400<=75) || (year%400>=168 && year%400<=199)){
				if(year%4 == 0 || year%4 == 1){
					if(day<22) return 5;
					else return 6;
				}
				else if(day<23) return 5;
				else return 6;
			}
			if(year%400>=76 && year%400<=99){
				if(year%4 == 3){
					if(day<23) return 5;
					else return 6;
				}
				else if(day<22) return 5;
				else return 6;
			}
			if(year%400>=300 && year%400<=319){
				if(year%4 == 0){
					if(day<23) return 5;
					else return 6;
				}
				else if(day<24) return 5;
				else return 6;
			}
			if((year%400>=200 && year%400<=223) || (year%400>=320 && year%400<=347)){
				if(year%4 == 0 || year%4 == 1){
					if(day<23) return 5;
					else return 6;
				}
				else if(day<24) return 5;
				else return 6;
			}
			if((year%400>=100 && year%400<=103) || (year%400>=224 && year%400<=251) || (year%400>=348 && year%400<=379)){
				if(year%4 == 3){
					if(day<24) return 5;
					else return 6;
				}
				else if(day<23) return 5;
				else return 6;
			}
			else if(day<23) return 5;
			else return 6;
		}
		if(month==10){
			if((year%400>=64 && year%400<=95) || (year%400>=192 && year%400<=199)){
				if(year%4 == 0){
					if(day<22) return 6;
					else return 7;
				}
				else if(day<23) return 6;
				else return 7;
			}
			if(year%400>=96 && year%400<=99){
				if(year%4 == 0 || year%4 == 1){
					if(day<22) return 6;
					else return 7;
				}
				else if(day<23) return 6;
				else return 7;
			}
			if((year%400>=200 && year%400<=203) || (year%400>=300 && year%400<=335)){
				if(day<24) return 6;
				else return 7;
			}
			if((year%400>=204 && year%400<=235) || (year%400>=336 && year%400<=367)){
				if(year%4 == 0){
					if(day<23) return 6;
					else return 7;
				}
				else if(day<24) return 6;
				else return 7;
			}
			if((year%400>=100 && year%400<=127) || (year%400>=236 && year%400<=267) || (year%400>=368 && year%400<=395)){
				if(year%4 == 0 || year%4 == 1){
					if(day<23) return 6;
					else return 7;
				}
				else if(day<24) return 6;
				else return 7;
			}
			if((year%400>=0 && year%400<=27) || (year%400>=128 && year%400<=155) || (year%400>=268 && year%400<=299) || (year%400>=396 && year%400<=399)){
				if(year%4 == 3){
					if(day<24) return 6;
					else return 7;
				}
				else if(day<23) return 6;
				else return 7;
			}
			else if(day<23) return 6;
			else return 7;
		}
		if(month==11){
			if((year%400>=52 && year%400<=83) || (year%400>=188 && year%400<=199)){
				if(year%4 == 0){
					if(day<21) return 7;
					else return 8;
				}
				else if(day<22) return 7;
				else return 8;
			}
			if(year%400>=84 && year%400<=99){
				if(year%4 == 0 || year%4 == 1){
					if(day<21) return 7;
					else return 8;
				}
				else if(day<22) return 7;
				else return 8;
			}
			if(year%400>=300 && year%400<=315){
				if(day<23) return 7;
				else return 8;
			}
			if((year%400>=200 && year%400<=215) || (year%400>=316 && year%400<=351)){
				if(year%4 == 0){
					if(day<22) return 7;
					else return 8;
				}
				else if(day<23) return 7;
				else return 8;
			}
			if((year%400>=100 && year%400<=115) || (year%400>=216 && year%400<=247) || (year%400>=352 && year%400<=383)){
				if(year%4 == 0 || year%4 == 1){
					if(day<22) return 7;
					else return 8;
				}
				else if(day<23) return 7;
				else return 8;
			}
			if((year%400>=0 && year%400<=15) || (year%400>=116 && year%400<=151) || (year%400>=248 && year%400<=279) || (year%400>=384 && year%400<=399)){
				if(year%4 == 3){
					if(day<23) return 7;
					else return 8;
				}
				else if(day<22) return 7;
				else return 8;
			}
			else if(day<22) return 7;
			else return 8;
		}
		if(month==12){
			if((year%400>=0 && year%400<=27) || (year%400>=132 && year%400<=163) || (year%400>=256 && year%400<=287) || (year%400>=392 && year%400<=399)){
				if(year%4 == 0){
					if(day<21) return 8;
					else return 9;
				}
				else if(day<22) return 8;
				else return 9;
			}
			if((year%400>=28 && year%400<=59) || (year%400>=164 && year%400<=195) || (year%400>=288 && year%400<=299)){
				if(year%4 == 0 || year%4 == 1){
					if(day<21) return 8;
					else return 9;
				}
				else if(day<22) return 8;
				else return 9;
			}
			if((year%400>=60 && year%400<=95) || (year%400>=196 && year%400<=199)){
				if(year%4 == 3){
					if(day<22) return 8;
					else return 9;
				}
				else if(day<21) return 8;
				else return 9;
			}
			if(year%400>=96 && year%400<=99){
				if(day<21) return 8;
				else return 9;
			}
			if(year%400>=300 && year%400<=319){
				if(year%4 == 0 || year%4 == 1){
					if(day<22) return 8;
					else return 9;
				}
				else if(day<23) return 8;
				else return 9;
			}
			if((year%400>=200 && year%400<=219) || (year%400>=320 && year%400<=355)){
				if(year%4 == 3){
					if(day<23) return 8;
					else return 9;
				}
				else if(day<22) return 8;
				else return 9;
			}
			else if(day<22) return 8;
			else return 9;
		}
		else return month;
	}

	public int shuku(){
		int cal = calenderId(day1);
		return (cal+9)%28;
	}

	public int distance(){
		int cal = calenderId(day1);
		return ((cal+9)%28)/7;
	}

	public int plus30Year(){
		int cal = calenderId(day1);
		if((cal/378+1)%30==0) return (cal/378+1)/30;
		if(cal%378==0) return (cal/378)/30;
		else return (cal/378+1)/30+1;
	}

	public int plusYear(){
		int cal = calenderId(day1);
		if((cal/378+1)%30==0) return 30;
		if(cal%378==0){
			if((cal/378)%30==0) return 30;
			else return (cal/378)%30;
		}
		else return (cal/378+1)%30;
	}

	public int plusDay(){
		int cal = calenderId(day1);
		if(cal%378==0) return 378;
		else return cal%378;
	}

	public String BirthdayId(){
		int cal1 = calenderId(day1);
		return String.format("誕生コード:%06d",cal1);
	}
	public String Age(){
		double y = date / 365.2425;
		double m = (y - (int)y) * 12;
		return String.format("年齢:%2d歳%2dヶ月",(int)y,(int)m);
	}
	public String LifeTime(){
		double h = (date / (365.2425*90))*24;
		double m = (h - (int)h) * 60;
		return String.format("人生時計:%02d時%02d分",(int)h,(int)m);
	}
	public String toString(){ return String.format("%s -> %s",day1,day2); }
	public String toString60(){
		String[] kan = {"甲","乙","丙","丁","戊","己","庚","辛","壬","癸"};
		String[] shi = {"子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"};
		return String.format("%s%s[年] %s%s[月] %s%s[日]",kan[kanYear()],shi[shiYear()],kan[kanMonth()],shi[shiMonth()],kan[kanDay()],shi[shiDay()]);
	}
	public String toString9star(){
		String[] ninestar = {"一白水星","二黒土星","三碧木星","四緑木星","五黄土星","六白金星","七赤金星","八白土星","九紫火星"};
		return String.format("%s[年] %s[月] %s[日]",ninestar[nineYear()],ninestar[nineMonth()],ninestar[nineDay()]);
	}
	public String toStringHoroscope(){
		String[] holoscope= {"牡羊(おひつじ)","牡牛(おうし)","双子(ふたご)","蟹(かに)","獅子(しし)","乙女(おとめ)","天秤(てんびん)","蠍(さそり)","射手(いて)","山羊(やぎ)","水瓶(みずがめ)","魚(うお)"};
		return String.format("%s座",holoscope[holoscope()]);
	}
	public String toString28shuku(){
		String[] shuku = {"角","亢","氏","房","心","尾","箕","斗","牛","女","虚","危","室","壁","奎","婁","胃","昴","畢","觜","参","井","鬼","柳","星","張","翼","軫"};
		String[] distance ={"東方青龍","北方玄武","西方白虎","南方朱雀"};
		return String.format("%s宿(%s)",shuku[shuku()],distance[distance()]);
	}
	public String toStringPlus(){
		return String.format("%d世%d年の第%d日目", plus30Year(), plusYear(), plusDay());
	}
}

class CalenderTester{

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		//System.out.println("開始日を入力せよ");
		System.out.println("誕生日を入力せよ");
		System.out.print("年：");  int y1 = stdIn.nextInt();
		System.out.print("月：");  int m1 = stdIn.nextInt();
		System.out.print("日：");  int d1 = stdIn.nextInt();
		//System.out.println("終了日を入力せよ");
		GregorianCalendar today = new GregorianCalendar();
		//System.out.print("年：");
		int y2 = today.get(YEAR);
		//System.out.print("月：");
		int m2 = today.get(MONTH)+1;
		//System.out.print("日：");
		int d2 = today.get(DATE);
		//int ss = 378; // 54週固定

		Days day1 = new Days(y1, m1, d1);	// 読み込んだ開始日
		Days day2 = new Days(y2, m2, d2);	// 読み込んだ終了日
		System.out.println();

		// 開始日と終了日指定
		//Calender calender1 = new Calender(day1,day2);
		//System.out.println("***Calender(開始日, 終了日)のテスト結果");
		//System.out.println("生成した期間：" + calender1.toString());
		//System.out.println("期間内の日数：" + calender1.getNumDates());

		// 開始日と終了日の変更
		Calender calender2 = new Calender();
		calender2.set(day1, day2);	// 開始日と終了日をセッタで設定
		//System.out.println("*** set(開始日, 終了日)のテスト結果");
		//System.out.println("生成した期間：" + calender2.toString());
		//System.out.println("期間内の日数：" + calender2.getNumDates());

		day1.set(1,1,1);	// ※day1の値を01/01/01に変更
		day2.set(1,1,1);	// ※day2の値を01/01/01に変更
		//System.out.println("*** 生成した期間の独立性の確認、" +
		//		"set(開始日, 終了日)と同じならばOK");
		System.out.println("生成した期間：" + calender2.toString());
		System.out.println("期間内の日数：" + calender2.getNumDates());

		System.out.printf("%s\n",calender2.toStringPlus());
		System.out.printf("%s\n",calender2.BirthdayId());
		System.out.println("干支:" + calender2.toString60());
		System.out.println("九星:" + calender2.toString9star());
		System.out.println("星座:" + calender2.toStringHoroscope());
		System.out.println("宿:" + calender2.toString28shuku());
		System.out.printf("%s\n",calender2.Age());
		System.out.printf("%s\n",calender2.LifeTime());
	}
}

class Days extends Calender{
	private int year = 1;
	private int month = 1;
	private int date = 1;

	//-- コンストラクタ --//
	public Days() { }
	public Days(int year) { this.year = year; }
	public Days(int year, int month) { this(year); this.month = month; }
	public Days(int year, int month, int date) { this(year,month); this.date = date; }
	public Days(Days d)  { this(d.year, d.month, d.date); }

	//-- 年・月・日を取得 --//
	public int getYear() { return year; }	//年を取得
	public int getMonth() { return month; }	//月を取得
	public int getDate() { return date; }	//日を取得

	//-- 年・月・日を設定 --//
	public void setYear(int year) { this.year = year; }	//年を設定
	public void setMonth(int month) { this.month = month; }	//月を設定
	public void setDate(int date) { this.date = date; }	//日を設定

	public void set(int year, int month, int date){
		this.year = year;	//年
		this.month = month;	//月
		this.date = date;	//日
	}

	//-- 曜日を求める --//
	public int dayOfWeek(){
		int y = year;
		int m = month;
		if(m == 1 || m == 2){
			y++;
			m += 12;
		}
		return(y+y/4-y/100+y/400+(13*m+8)/5+date)%7;
	}

	//-- 日付dと等しいか --//
	public boolean equalTo(Days d){
		return year == d.year && month == d.month && date == d.date;
	}

	//-- 文字列表現の返却 --//
	public String toString(){
		String[] wd = {"日","月","火","水","木","金","土"};
		return String.format("%04d年%02d月%02d日(%s)",year,month,date,wd[dayOfWeek()]);
	}

}
