$(function() {
	var data = {
		"galleryList" : [{
			"img" : "/resources/images/tmpl/thumb-01.jpg",
			"subject" : "바다여행에서의 피부관리 노하우",
			"content" : "자외선 걱정없이 바다여행 즐기기 노하우",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-02.jpg",
			"subject" : "서울 시내 봄철 꽃 나들이 10선",
			"content" : "한강에서 바라보는 유채의 향연! 서래섬 유채축제를 소개합니다.",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-03.jpg",
			"subject" : "휴식을 위한 여행",
			"content" : "도심 속 지친 나에게 선물하는 치유여행",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-04.jpg",
			"subject" : "여행을 떠나기 전 체크사항",
			"content" : "잊은 물건은 없을까? 여행 전 체크리스트 102가지.",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-05.jpg",
			"subject" : "친환경이 대세다! 자전거로 떠나는 여행",
			"content" : "자전거로 달리며 볼 수 있는 아름다운 광경들..",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-06.jpg",
			"subject" : "야경이 아름다운 곳에서",
			"content" : "밤 시간도 아쉬운 커플들에게 희소식! 야경이 아름다운 데이트 추천지 10선!",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-07.jpg",
			"subject" : "스마트한 결혼준비 2탄",
			"content" : "결혼 선배들에게 듣는 웨딩드레스 잘 고르는 법",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-08.jpg",
			"subject" : "권태기가 올 줄은...",
			"content" : "권태기! 우리 커플은 이렇게 극복했다. 권태기 극복 노하우 대 공개!",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-09.jpg",
			"subject" : "특별한 날, 완벽준비 가이드",
			"content" : "요조숙녀처럼, 요부처럼! 특별한 밤 그이의 몸과 영혼을 사로잡는 비법!!!",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-10.jpg",
			"subject" : "추억의 사진 복원",
			"content" : "한 장의 사진들도 놓칠 수 없다. 폴라로이드 사진을 디지털로!!!",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-11.jpg",
			"subject" : "일이냐, 사랑이냐. 그것이 문제로다.",
			"content" : "알파걸들에게 듣는 결혼과 사랑에 관한 솔직담백 토크.",
			"pubDate" : "2013-12-01"
		}, {
			"img" : "/resources/images/tmpl/thumb-12.jpg",
			"subject" : "흡연에 관한 서로의 진실",
			"content" : "남녀사이 흡연을 둘러싼 다양한 논쟁들.",
			"pubDate" : "2013-12-01"
		}]
	};

	// json배열을 템플릿에 통째로 지정하면 템플릿이 자동으로 반복처리한다.
	var div = $("#itemTemplate").tmpl(data.galleryList);
	// 템플릿이 생성한 동적 요소를 화면에 출력한다.
	$("#galleryList").append(div);
});