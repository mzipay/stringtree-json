package org.stringtree.json;

public class ExceptionErrorListener extends BufferErrorListener {
    private boolean exposeJsonSource;

    public ExceptionErrorListener() {
        this(true);
    }

    public ExceptionErrorListener(boolean exposeJsonSource) {
        this.exposeJsonSource = exposeJsonSource;
    }

    @Override
    public void error(String type, int col) {
        if (exposeJsonSource) {
            super.error(type, col);
        } else {
            buffer.append("expected ").append(type).append(" at column ").append(col);
        }
        throw new IllegalArgumentException(buffer.toString());
    }
}
