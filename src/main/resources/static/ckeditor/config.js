/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'about' }
	];

	config.removeButtons = 'Source,Save,NewPage,Scayt';
	config.image_previewText=' ';     //预览区域显示内容
	// config.filebrowserImageBrowseUrl = '/browse/mgmt/img';
	// config.filebrowserImageUploadUrl = '/upload/mgmt/img';
	// config.extraPlugins = 'image2,uploadimage';

	config.uploadUrl = '/images/ckeditorUpload?command=QuickUpload&type=Files&responseType=json';
	config.filebrowserUploadUrl = '/images/ckeditorUpload?command=QuickUpload&type=Files';
	config.filebrowserImageUploadUrl = '/images/ckeditorUpload?command=QuickUpload&type=Images';
	config.extraPlugins = 'image2';
	// config.filebrowserImageBrowseUrl = 'ckeditor/browse/?CKEditor=id_body';
	// config.filebrowserImageBrowseUrl = '/images/ckeditorUpload?command';


};

	// // Remove some buttons provided by the standard plugins, which are
	// // not needed in the Standard(s) toolbar.
	// config.removeButtons = 'Underline,Subscript,Superscript';
	//
	// // Set the most common block elements.
	// config.format_tags = 'p;h1;h2;h3;pre';
	//
	// // Simplify the dialog windows.
	// config.removeDialogTabs = 'image:advanced;link:advanced';
	//
	// config.uploadUrl = '/images/ckeditorUpload?command=QuickUpload&type=Files&responseType=json';
	// config.filebrowserUploadUrl = '/images/ckeditorUpload?command=QuickUpload&type=Files';
	// config.filebrowserImageUploadUrl = '/images/ckeditorUpload?command=QuickUpload&type=Images';


	// config.removeButtons = 'Source,Save,NewPage,Scayt';
	// config.image_previewText=' ';     //预览区域显示内容
	// config.filebrowserImageBrowseUrl = '/browse/mgmt/img';
	// config.filebrowserImageUploadUrl = '/upload/mgmt/img';
	// config.extraPlugins = 'image2,uploadimage';


