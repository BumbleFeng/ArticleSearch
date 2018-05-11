package com.nytimes.pojo;

import java.util.ArrayList;

public class Response {
	private ArrayList<Docs> docs;
	private Meta meta;

	public Response() {
	}

	public ArrayList<Docs> getDocs() {
		return docs;
	}

	public void setDocs(ArrayList<Docs> docs) {
		this.docs = docs;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

}
