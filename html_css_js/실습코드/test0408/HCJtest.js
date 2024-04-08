let basicDatas = [
  { id: 1, title: "Todo 1", done: false },
  { id: 2, title: "Todo 2", done: true },
];

function renderTodoList() {
  const todoList = document.getElementById("todo-item-list");
  todoList.innerHTML = ""; // 리스트를 초기화

  // basicDatas를 반복하면서 각 요소를 리스트에 추가
  basicDatas.forEach((data) => {
    const todoItem = document.createElement("li");
    todoItem.classList.add("todo-item");
    todoItem.innerHTML = `
                    <span class="todo-text">${data.title}</span>
                    <span class="remove">❌</span>
                `;
    todoList.appendChild(todoItem);
  });
}

window.addEventListener("DOMContentLoaded", function () {
  renderTodoList();
});

const todoBtn = document.getElementById("todoBtn");
const todo = document.getElementById("todoValue");
const ul = document.querySelector("ul");

todoBtn.addEventListener("click", () => {
  const li = document.createElement("li");
  const text = document.createTextNode(todo.value);
  li.appendChild(text);
  ul.appendChild(li);
  renderTodoList();
  todo.value = "";
});

ul.addEventListener("click", (e) => {
  e.target.innerText.text;
});
