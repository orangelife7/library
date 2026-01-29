app.component('createButton', {
    bindings: {
        onCreate: '&',
        label: '@'
    },
    templateUrl: getComponentPath('create-button')
});