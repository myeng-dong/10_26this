const modalText = document.querySelectorAll('.question_text_modal');
const firstModal = document.getElementById('first_modal');
const xMark = document.querySelector(".fa-solid.fa-xmark.fa-bounce");
const modalContent = document.getElementById('modalContent');
const modalTextContent = document.getElementById('modalText');

function h_write() {
   const linkText = this.textContent;
   modalContent.textContent = linkText;

   const pContent = this.nextElementSibling.textContent;
   modalTextContent.textContent = pContent;

   firstModal.showModal();
}

function outer(){
   firstModal.close();
}

[...modalText].forEach(curr => {
   curr.addEventListener('click', h_write);
});

xMark.addEventListener('click',outer);



