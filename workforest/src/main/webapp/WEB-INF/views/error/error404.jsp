<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="content">
	<div class="error-page">
		<h2 class="headline text-warning">404</h2>
		<div class="error-content">
			<h3>
				<i class="fas fa-exclamation-triangle text-warning"></i> Oops! Bad King-Cho-Rock
				not found
			</h3>
			<p>
				요청한 문서를 찾지 못했슴돠~ <br>만약, 메인으로 이동하고자 한다면<br>
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