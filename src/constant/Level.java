package constant;

public enum Level {
    GSTS(1), PGSTS(2), THACSI(4),GIANGVIENCHINH(3);
    private Integer code;

    Level(Integer  code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    Level() {

    }
}
