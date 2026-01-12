app.component('physicalBookList', {
  bindings: {bookId: '<'},
  templateUrl: '/js/components/physical-book-list/physical-book-list.component.html',
  controller: function($http) {
    const ctrl = this;

    ctrl.$onInit = function() {
      $http.get('http://localhost:8080/api/book/' + ctrl.bookId )
        .then(function(res) {
          ctrl.copies = res.data;
        })
        .catch(function() {
          ctrl.copies = [];
        });
    };
  }
});