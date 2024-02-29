<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<section class="content">
	<div class="error-page">
	<!-- model.addAttribute("exception", e); -->
		<h2 class="headline text-warning">${exception.getMessage()}</h2>
		<div class="error-content">
		<c:forEach var="stack" items="${exception.getStackTrace()}" varStatus="stat">
			<h3>
				<i class="fas fa-exclamation-triangle text-warning"></i>${stack.toString()}
			</h3>
		</c:forEach>
			<p>
				<%=exception.getMessage() %> 만약, 메인으로 이동하고자 한다면
				<a href="/">메인으로 가기</a>를 클릭하세요.
			</p>
			<form class="search-form">
				<div class="input-group">
					<input type="text" name="search" class="form-control"
						placeholder="Search">
					<div class="input-group-append">
						<button type="submit" name="submit" class="btn btn-warning">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</section>