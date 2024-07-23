function showEditForm(commentId) {
    document.getElementById('comment-' + commentId).querySelector('.comment-content').style.display = 'none';
    document.getElementById('edit-form-' + commentId).style.display = 'block';

    // 기존 댓글 내용 가져오기
    fetch('/comments/' + commentId)
        .then(response => response.json())
        .then(data => {
            document.getElementById('edit-content-' + commentId).value = data.content;
        });
}

function cancelEdit(commentId) {
    document.getElementById('comment-' + commentId).querySelector('.comment-content').style.display = 'block';
    document.getElementById('edit-form-' + commentId).style.display = 'none';
}

function submitEdit(commentId) {
    const content = document.getElementById('edit-content-' + commentId).value;

    fetch('/comments/' + commentId + '/edit', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: 'content=' + encodeURIComponent(content)
    }).then(response => {
        if (response.ok) {
            location.reload();
        } else {
            alert('Failed to update comment');
        }
    });
}

function loadComments(postId, page) {
    fetch(`/posts/${postId}?page=${page}`)
        .then(response => response.text())
        .then(html => {
            const parser = new DOMParser();
            const doc = parser.parseFromString(html, 'text/html');
            const commentsSection = doc.querySelector('.comments-section');
            const currentCommentsSection = document.querySelector('.comments-section');
            if (commentsSection && currentCommentsSection) {
                currentCommentsSection.innerHTML = commentsSection.innerHTML;
            } else {
                console.error('Comments section not found');
            }
        })
        .catch(error => {
            console.error('Error loading comments:', error);
        });
}