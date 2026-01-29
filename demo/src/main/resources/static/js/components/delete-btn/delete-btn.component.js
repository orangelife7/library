app.component('deleteBtn', {
    bindings: {
        onDelete: '&',
       itemId: '<'
    },
    templateUrl: getComponentPath('delete-btn')
});