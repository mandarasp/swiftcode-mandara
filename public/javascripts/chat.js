var app = angular.module('chatApp', ['ngMaterial']);
app.controller('chatController', function ($scope) {
    $scope.message = [{
            'sender': 'USER',
            'text': 'hello'
    }, {
            'sender': 'BOT',
            'text': 'hi hello'
    }
    ]
});