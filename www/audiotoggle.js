var exec = require('cordova/exec');

exports.SPEAKER = 'speaker';
exports.EARPIECE = 'earpiece';
exports.NORMAL = 'normal';
exports.RINGTONE = 'ringtone';
exports.TEST = 'HELLO';

exports.setAudioMode = function (mode) {
	cordova.exec(null, null, 'toggleaudioplugin', 'setAudioMode', [mode]);
};
