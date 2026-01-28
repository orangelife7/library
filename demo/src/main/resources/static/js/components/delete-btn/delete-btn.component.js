app.component('deleteBtn', {
    bindings: {
        onDelete: '&',
       itemId: '<'
    },
    templateUrl: '/js/components/delete-btn/delete-btn.component.html'
});