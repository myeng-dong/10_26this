let arr = ['청소/이사','레슨','디자인/개발','도우미','펫','기타'];
      const $bigCategory = document.querySelectorAll('.main2 > .item_box_bottom');
      let result = null;
      function sendData()
      {    for(let j = 0; j < $bigCategory.length; j++){
              // 상단카테고리를 이벤트리스너로 만든다
              $bigCategory[j].addEventListener('click',(e)=>{
                  //이미지 클릭 시 e.target(img)와 자식요소(.box1 img)를 비교해 참인걸 비교한다

              for(let i = 0; i < 6; i++){
              if(e.target == $bigCategory[j].children[i].children[0].children[0]){
                  //참일시 (.box2 textContent를 출력한다)

                  // console.log(arr[j],$bigCategory[j].children[i].children[1].textContent);
                  result = (arr[j]+ "  " +$bigCategory[j].children[i].children[1].textContent);
                  localStorage.setItem('category',result);
                  window.location.assign('http://localhost:9080/give/detail');
                  i = 10;
                  break;
                  }
              }});
          };}
          sendData();
