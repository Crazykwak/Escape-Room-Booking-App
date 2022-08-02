window.onload = () => {
  console.log('test');
  init();
}

const init = () => {
  // 로그인 버튼
  const loginBtn = document.querySelector('#btn-login');
  loginBtn.addEventListener('click', () => {
    window.location.href = '/members/login';
  });

  // 회원가입 버튼
  const signupBtn = document.querySelector('#btn-signup');
  signupBtn.addEventListener('click', () => {
    window.location.href = '/members/new';
  });

  // 로그아웃 버튼
  const loginBtn = document.querySelector('#btn-logout');
    loginBtn.addEventListener('click', () => {
      window.location.href = '/members/logout';
    });
}