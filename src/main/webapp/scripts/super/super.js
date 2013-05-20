function readonlyModel(form, callback) {
	var fields = form.getFields();
	for ( var i = 0, l = fields.length; i < l; i++) {
		var c = fields[i];
		if (c.setReadOnly)
			c.setReadOnly(true); // 只读
		if (c.addCls)
			c.addCls("asLabel"); // 增加asLabel外观
		if (c.name == 'state') {
			c.value = '';
		}
		if (callback)
			callback(c);
	}
}

function editModel(form, state, callback) {
	var fields = form.getFields();
	if (state == 'added') {
		form.reset();
	}
	for ( var i = 0, l = fields.length; i < l; i++) {
		var c = fields[i];
		if (c.setReadOnly)
			c.setReadOnly(false);
		if (c.removeCls)
			c.removeCls("asLabel");
		if (c.name == 'state') {
			c.value = state;
		}
		if (callback)
			callback(c);
	}
	
	mini.repaint(document.body);
}