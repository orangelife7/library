// Zadanie 3 - 4
app.component('postList', {
	templateUrl: '/js/components/posts-list/post-list.component.html',
	controller: function($http) {
		const ctrl = this;
			
		ctrl.posts = [
			{
				userId: 11,
				id: 101,
				title: "Przykladowy post 101",
				body: "Test 1."
				
			},
			{
				userId: 12,
				id: 102,
				title: "Przykladowy post 102 dla testu",
				body: "Test 2."
			},
			{
				userId: 13,
				id: 103,
				title: "Przykladowy post 103 dla testu, jeszcze jeden",
				body: "Test 3."
			}
		];
			
		// Zadanie 5
		ctrl.download = function() {
		//Wysyłamy zapytanie GET
		$http.get('https://jsonplaceholder.typicode.com/posts/')
		.then(function(response) {
		console.log(response.data);
		response.data.forEach(r => ctrl.posts.push(r));
		//ctrl.posts = response.data;
		})
		.catch(function(error) {
			console.error('Blad: ' + error);
			})
		};
		
		//Zadanie 6
		ctrl.loadComments = function(post) {
			const url = "https://jsonplaceholder.typicode.com/comments?postId=" + post.id;
			
			$http.get(url)
			.then(function(response) {
				post.comments = response.data;
			})
			.catch(function(error) {
				console.error('Blad pobierania komentarzy: ' + error);
			}).finally(r => {
				post.downloaded = true;
			});
		}
		
	}
});








