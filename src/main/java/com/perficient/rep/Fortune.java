package com.perficient.rep;

public class Fortune {

    private Long id;

    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

	public Fortune(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

	public Fortune() {
		super();
	}
    
    
}
