package kr.or.ddit.util;

import java.util.List;

//페이징 관련 정보 + 게시글 정보
//new ArticlePage<FreeBoardVO>(total, currentPage, size, content);
//                              753     1           10
public class ArticlePage<T> { //여기도 제네릭 써주기
	
	//전체 글 수
	private int total;
	//현재 페이지 번호
	private int currentPage;
	//전체 페이지 번호
	private int totalPages; 
	//블록의 시작 페이지 번호
	private int startPage;
	//블록의 종료 페이지 번호
	private int endPage;
	//검색어
	private String keyword= "";
	//요청 URL
	private String url= "";
	//select 결과 데이터
	private List<T> content; //제네릭 사용
	//페이징 처리
	private String pagingArea= "";
	
	
	//생성자(Constructor): 페이지 정보를 생성
	public ArticlePage(int total, int currentPage, int size, List<T> content, String keyword) {
		//size: 한 화면에 보여질 목록의 행의 수
		this.total= total;
		this.currentPage= currentPage;
		this.content= content;
		this.keyword= keyword;
		
		
		//전체 글 수가 0이면..(글이 없다면)
		if(total==0) {
			totalPages= 0; //전체 페이지 수
			startPage= 0; //블록 시작번호
			endPage= 0; //블록 종료번호
			
		} else { //글 수가 1이상 이면(글이 있다면)
			//전체 페이지 수= 전체 글 수 / 한 화면에 보여질 목록의 행의 수 
			//totalPages= total/size (3= 31/10 -> /는 몫만)
			totalPages= total / size; //10행씩 75페이지
			//나머지가 있다면, 페이지 1 증가 (글이 31개이면 3페이지 하고도 1페이지 더 있어야 하니까)
			if(total%size>0) { //나머지 3행을 위한 1페이지 있어야 함
				totalPages++; //총 76페이지
			}
			
			//페이지 블록 시작 번호를 구하는 공식
			//블록 시작 번호= 현제페이지/페이지크기*페이지크기+1
			startPage= currentPage/5*5+1;
			
			//현재페이지%페이지크기 ==0일 때 보정하기
			if(currentPage%5==0) {
				startPage -=5;
			}
			
			//블록 종료 번호= 시작페이지번호+(페이지크기-1)
			endPage= startPage+(5-1);
			
			//종료페이지 > 전체 페이지 수
			if(endPage>totalPages) {
				endPage= totalPages;
			}		
		} //else 끝

		pagingArea += "<div class='col-sm-12 col-md-7'>";
		pagingArea += "<div class='dataTables_paginate paging_simple_numbers' id='example2_paginate'>";
		pagingArea += "<ul class='pagination'>";
		pagingArea += "<li class='paginate_button page-item previous "; 
		if(this.startPage<6) {
			pagingArea += "disabled ";
		}
		pagingArea += "'";
		pagingArea += "id='example2_previous'>";
		pagingArea += "<a href='"+this.url+"?currentPage="+(this.startPage-5)+"&keyword="+this.keyword+"' aria-controls='example2' data-dt-idx='0' tabindex='0' ";
		pagingArea += "class='page-link'>Previous</a></li>";
		
		for(int pNo=this.startPage;pNo<=this.endPage;pNo++) {		
		pagingArea += "<li class='paginate_button page-item ";
			if(this.currentPage == pNo) {
				pagingArea += "active";
			}
			pagingArea += "'>";
			pagingArea += "<a href='"+this.url+"?currentPage="+pNo+"&keyword="+this.keyword+"' aria-controls='example2' data-dt-idx='1' tabindex='0' ";
			pagingArea += "class='page-link'>"+pNo+"</a>";
			pagingArea += "</li>";
		}
		pagingArea += "<li class='paginate_button page-item next "; 
		if(this.endPage>=this.totalPages) {
			pagingArea += "disabled";
		}
		pagingArea += "' id='example2_next'><a ";
		pagingArea += "href='"+this.url+"?currentPage="+(this.startPage+5)+"&keyword="+this.keyword+"' aria-controls='example2' data-dt-idx='7' ";
		pagingArea += "tabindex='0' class='page-link'>Next</a></li>";
		pagingArea += "</ul>";
		pagingArea += "</div>";
		pagingArea += "</div>";
	} //생성자 끝

	//getter,setter 시작
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
	//getter,setter 끝
	
	
	//전체 글의 수가 0인가?
	public boolean hasNoArticles() {
		return this.total== 0;
	}
	
	
	//데이터가 있나?
	public boolean hasArticles() {
		return this.total>0;
	}
	
	//페이징 블록을 자동화
	public String getPagingArea() {
		return this.pagingArea;
	}

	public void setPagingArea(String pagingArea) {
		this.pagingArea = pagingArea;
	}
	
	
	
}
































