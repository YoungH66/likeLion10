document.addEventListener('DOMContentLoaded', function() {
    console.log('DOM fully loaded and parsed');

    // 현재 페이지 URL을 확인
    const currentPath = window.location.pathname;

    // 회원가입 페이지 관련 코드
    if (currentPath.includes('/signup')) {
        const signupForm = document.getElementById('signupForm');
        if (signupForm) {
            signupForm.addEventListener('submit', function(event) {
                const username = document.getElementById('username').value;
                const email = document.getElementById('email').value;
                const password = document.getElementById('password').value;

                if (!username || !email || !password) {
                    event.preventDefault();
                    alert('모든 필드를 채워주세요.');
                }
            });
        }

        // 사용자 이름 중복 체크
        const usernameInput = document.getElementById('username');
        if (usernameInput) {
            usernameInput.addEventListener('blur', function() {
                const username = this.value;
                if (username) {
                    fetch(`/api/check-username?username=${encodeURIComponent(username)}`)
                        .then(response => response.json())
                        .then(data => {
                            if (data) {
                                alert('이미 사용 중인 사용자 이름입니다.');
                            }
                        });
                }
            });
        }

        // 이메일 중복 체크
        const emailInput = document.getElementById('email');
        if (emailInput) {
            emailInput.addEventListener('blur', function() {
                const email = this.value;
                if (email) {
                    fetch(`/api/check-email?email=${encodeURIComponent(email)}`)
                        .then(response => response.json())
                        .then(data => {
                            if (data) {
                                alert('이미 사용 중인 이메일입니다.');
                            }
                        });
                }
            });
        }
    }

    // 로그인 페이지 관련 코드
    if (currentPath.includes('/login')) {
        const loginForm = document.getElementById('loginForm');
        if (loginForm) {
            loginForm.addEventListener('submit', function(event) {
                const username = document.getElementById('username').value;
                const password = document.getElementById('password').value;

                if (!username || !password) {
                    event.preventDefault();
                    alert('사용자 이름과 비밀번호를 입력해주세요.');
                }
            });
        }
    }
});