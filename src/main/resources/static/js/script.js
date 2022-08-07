window.onload = () => {
  console.log('test');
  init();
}

const init = () => {
  // 로그인 버튼

  try {
    const loginBtn = document.querySelector('#btn-login');
    loginBtn.addEventListener('click', () => {
      window.location.href = '/members/login';
    });
  } catch (err) {
    // 로그아웃 버튼
    const logoutBtn = document.querySelector('#btn-logout');
    logoutBtn.addEventListener('click', () => {
      window.location.href = '/members/logout';
    });
  }

  // 회원가입 버튼
  const signupBtn = document.querySelector('#btn-signup');
  signupBtn.addEventListener('click', () => {
    window.location.href = '/members/new';
  });


}