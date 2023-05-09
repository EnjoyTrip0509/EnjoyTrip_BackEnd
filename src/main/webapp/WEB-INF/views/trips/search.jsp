<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
   <%@ include file="../common/nav.jsp" %>
	 <div>
	   <h3 class = "mt-3" id = "tripSearchTitle">지역별 관광정보</h3>
	   <hr>
	 </div>
	 <div class="select-container">
	 	<form method="post" action="${root}/attraction"class="search-form">
	 		<input type="hidden" name="action" value="search">
	 		
	 		<!-- 검색 select 구역 -->
	 		<select
		        id="search-area"
		        class="form-select"
		        aria-label="Default select example"
		        name="areaCode"
	  	        onchange="getGuGun(this.value)"        
		      >
			      <c:forEach items="${sidos}" var="sido">
			      	<option value=${sido.sidoCode} >${sido.sidoName}</option>
			      </c:forEach>
		 	</select>
		 	
		 	<select
	         id="search-area-gugun"
	         class="form-select"
	         aria-label="Default select example"
	         name="sigunguCode"
	        ></select>
	        
	        <select id="search-content-id" class="form-select" aria-label="Default select example" name="contentTypeId">
	         <option value="0" selected>관광지 유형</option>
	         <option value="12">관광지</option>
	         <option value="14">문화시설</option>
	         <option value="15">축제공연행사</option>
	         <option value="25">여행코스</option>
	         <option value="28">레포츠</option>
	         <option value="32">숙박</option>
	         <option value="38">쇼핑</option>
	         <option value="39">음식점</option>
	       </select>
	       
	       <button type="button" id="btn-search" onclick="getAttraction()" class="btn btn-outline-success" type="button">검색</button>
	 	</form>
	 </div>
	 
	 <div class="map-container">
	   <div id="map"></div>
	 </div>
	 
	 
	 
	 <script src="${root}/resources/static/js/search.js"></script>
	 
	 <script>
	 	function getGuGun(code) {
	 		fetch("${root}/attraction/gugun?sidoCode=" + code)
	 		.then((response) => response.json())
	 		.then((data) => {
	 			const template = makeGuGunOption(data);
	 		});
	 	}
	 	
	 	getGuGun(1);
	 	
	 	function getAttraction() {
	 		document.getElementById("btn-search").addEventListener("click", (e) => {
	 			e.preventDefault();
	 				 			
	 			let searchUrl = "${root}/attraction/search?";
	 			
	 			let sidoCode = document.getElementById("search-area").value;
	 		    let contentTypeId = document.getElementById("search-content-id").value;
	 		    let gugunCode = document.getElementById("search-area-gugun").value;
	 		    
	 		    console.log(sidoCode, contentTypeId, gugunCode);
	 		    
	 		    if (parseInt(sidoCode)) {
	 		    	 searchUrl += "sidoCode=" + sidoCode;
	 		    }
	 		 
	 		    if (parseInt(contentTypeId)) {
	 		    	searchUrl += "&contentTypeId=" + contentTypeId;
	 		    }
	 		   
	 		    if (parseInt(gugunCode)) {
	 		    	searchUrl += "&gugunCode=" + gugunCode;
	 		    }
	 		    
	 		    console.log(searchUrl);
	 		    
	 		    fetch(searchUrl)
	 		    .then((response) => response.json())
	 		    .then((data) => {
	 		    	makeList(data)
	 		    });
	 		});
	 	}
	 	
	 	function add(dataset) {
	 		const { contentid } = dataset;
	 		fetch("${root}/mytrip/add?content_id=" + contentid);
	 	}
	 </script>
<%@ include file="../common/footer.jsp" %>