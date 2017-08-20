/**
 * https://github.com/DaniVSainz
 * @Author danivsainz@gmail.com
 */
package github;

/**
 * @author daniel
 *
 */
public class GithubUser {
	public String date;
	public String commit;
	String[] day;
	public String[] days = new String[]{};

	
	public void setCommit(String day) {
		this.date = day;
	}
	public String getCommit() {
		return date;
	}
	public void setDate(String date) {
		this.date=date;
	}
	public String getDate() {
		return date;
	}
	public String[]  setday() {
		this.day[0]=getDate();
		this.day[1]=getCommit();
		return day;
	}
	
//	public void setDays(int index) {
//		days[index] = setday();
//	}

}
