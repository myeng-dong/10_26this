
const postList = document.getElementById("postList");
const posts = [
  { title: "청소/이사 가정집 청소"
,   date: "협의 가능해요"
,   content: "이 녀석들 내 성격 까먹었나보네."
,   area: "울산 / 남구"
,   nickname: "테스터1"
,   image: "/img/기타/공예.jpg" },
   { title: "청소/이사 가정집 청소"
,   date: "협의 가능해요"
,   content: "이 녀석들 내 성격 까먹었나보네."
,   area: "울산 / 남구"
,   image: "/img/기타/공예.jpg" },
   { title: "청소/이사 가정집 청소"
,   date: "협의 가능해요"
,   content: "이 녀석들 내 성격 까먹었나보네."
,   area: "울산 / 남구"
,   image: "/img/기타/공예.jpg" },

];

function fetchPosts() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(posts);
    }, 1000);
  });
}

async function displayPosts() {
    const fetchedPosts = await fetchPosts();
    fetchedPosts.forEach((post) => {
      const postItem = document.createElement("li");
      postItem.classList.add("post");
      postItem.innerHTML =
      `
      <div class="main_top">
                      <div class="main_info">
                          <div class="pic">
                              <div class="profile"><img th:src="${post.image}"></div>
                          </div>
                          <div class="info">
                              <div class="hope">
                                  <div class="hope_list">
                                      <div class="hope_title"><h3>${post.nickname}</h3></div>
                                      <div class="hope_text">
                                        ${post.content}
                                      </div>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="info_top_p">
                          <div class="info_top">
                              <div class="job">
                               분야 : ${post.title}
                              </div>
                              <div class="local">
                               지역 : ${post.area}
                              </div>
                              <div class="date">
                               희망날짜 : ${post.date}
                              </div>
                          </div>
                      </div>
                      <button class="button colorbutton">견적서 작성</button>
                  </div>
    </div>
    `;
      postList.appendChild(postItem);
    });
  }
displayPosts();