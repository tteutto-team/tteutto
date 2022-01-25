<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../common/header.jsp"/>
<link rel="stylesheet" href="${contextPath}/resources/css/notice_list.css"/>
<div id ="container">
    <main>
        <div id="container_header">
            <h1>자주 묻는 질문</h1>
        </div>
        <div class="select_tab">
            <div class="tab" id="student">학생</div>
            <div class="tab_on" id="teacher">강사</div>
        </div>
        <div id ="faq_list">
            <div class="faq">
                <span class="faq_title">
                    <span class="faq_title_no">1&nbsp;&nbsp;</span>
                    수업 신청 후 절차가 어떻게 되나요?
                </span><br>
                원데이 수업 : 전체수업료를 한번에 결제하는 전체결제로 진행이 됩니다<br>
                2회차 이상의 수업 : 뜨또에서 전체수업료를 가지고 있다가 첫 수업이 마친 후 뜨또 수수료인 1시간 수업료를 제외한 나머지 금액을 튜터님께 돌려드리고 있어요
            </div>
            <div class="faq">
                <span class="faq_title">
                    <span class="faq_title_no">2&nbsp;&nbsp;</span>
                    수업료는 어떻게 결제하나요?
                </span><br>
                    수업신청은 " 수업신청서 발급 >> 결제완료 >> 튜터님의 수업승인 >> 수업매칭" 으로 절차가 진행됩니다!<br>
                    튜터님과 연결되시면 일정을 조율하여 첫 수업날짜를 잡아보세요
            </div>
            <div class="faq">
                <span class="faq_title">
                    <span class="faq_title_no">3&nbsp;&nbsp;</span>
                    결제방식은 어떻게 되나요?
                </span><br>
                앱과 PC에서 카드 / 무통장으로 결제 하실 수 있습니다.
            </div>
            <div class="faq">
                <span class="faq_title">
                    <span class="faq_title_no">4&nbsp;&nbsp;</span>
                    강사의 수업 퀄리티를 신뢰할 수 있을까요?
                </span><br>
                뜨또에서 강사에 대한 철저한 사전검증을 하게 되며, 프로필 상의 경력과 자격증에 대한 검수확인 과정을 거치게 됩니다.<br>
                또한 실제 수업을 들었던 수강생의 리뷰와 피드백을 통해 튜터의 평판을 지속적으로 관리합니다. 뜨또는 계속해서 강사들의 신뢰도를 높일 수 있는 검증 시스템을 만들어 갈 것임을 약속드립니다.
            </div>
        </div>
    </main>
</div>

<jsp:include page="../common/footer.jsp"/>