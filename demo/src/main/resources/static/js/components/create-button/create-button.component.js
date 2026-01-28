app.component('createButton', {
    bindings: {
        onCreate: '&',
        label: '@'
    },
    templateUrl: '/js/components/create-button/create-button.component.html'
});