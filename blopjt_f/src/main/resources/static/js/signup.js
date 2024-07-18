$(document).ready(function() {
    $('#username').blur(function() {
        let username = $(this).val().trim();
        if (username) {
            $.get('/api/check-username?username=' + encodeURIComponent(username), function(exists) {
                if (exists) {
                    $('#usernameError').text('Username already exists');
                } else {
                    $('#usernameError').text('');
                }
            });
        } else {
            $('#usernameError').text('');
        }
    });

    $('#email').blur(function() {
        let email = $(this).val().trim();
        if (email) {
            $.get('/api/check-email?email=' + encodeURIComponent(email), function(exists) {
                if (exists) {
                    $('#emailError').text('Email already exists');
                } else {
                    $('#emailError').text('');
                }
            });
        } else {
            $('#emailError').text('');
        }
    });

    $('#signupForm').submit(function(event) {
        let username = $('#username').val().trim();
        let email = $('#email').val().trim();
        let password = $('#password').val();

        if (!username || !email || !password) {
            event.preventDefault();
            alert('Please fill in all fields.');
            return;
        }

        if ($('#usernameError').text() !== '' || $('#emailError').text() !== '') {
            event.preventDefault();
            alert('Please correct the errors before submitting.');
        }
    });
});