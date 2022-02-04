
// 카카오 로그아웃
function unlinkApp() {
	Kakao.init('c2fadae20e5509a211c93e833342aa29');
    Kakao.API.request({
      url: '/v1/user/unlink',
      success: function(res) {
        alert('success: ' + JSON.stringify(res))
      },
      fail: function(err) {
        alert('fail: ' + JSON.stringify(err))
      },
    })
  }
