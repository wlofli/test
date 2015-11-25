package base.wolf.struct;
/**
 * author lzc2015年7月23日下午4:03:51
 */
public class Page {
	
//	private int totalPage;//总页数
	private int totalNum;//总条数
	private int pageNo;//当前页数
	private int pageSize;//页码大小
	private int startIndex;//开始显示页数 n
//	private int endIndex;//结束显示页数
	
	/**分页理解
	 * add by lzc     date: 2015年8月8日
	 * totalPage -> y
	 * pageNo -> x
	 * startIndex ->n
	 * 
	 * 1. y < x + n
	 * 	1.1 x < n
	 *  1.2 x > n
	 * 2. y > x + n
	 * 	2.1 x < n
	 * 	2.2 x > n
	 */
	
	
	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	
	
	//总页数
	public int getTotalPage() {
		if(pageSize != 0 && totalNum !=0){
			if(totalNum % pageSize == 0){
				return totalNum/pageSize;
			}
			return (totalNum / pageSize) + 1 ;
		}else {
			return 1;
		}
	}

	

	//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	public int getTotalNum() {
	
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
