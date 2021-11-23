package me.yangjun.study.枚举;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mooejun
 * @since 2020/11/02 22:28
 */
public enum FlowEnum {
	GTS("GTS Role"),
	BU("BU"),
	SDT("SDT"),
	;

	FlowEnum(String code) {
		this.code = code;
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "FlowEnum{" +
				"code='" + code + '\'' +
				'}';
	}

	public static void main(String[] args) {
		String[] flowArr = {"GTS", "BU"};
		List<FlowEnum> flowEnums = new ArrayList<>();
		Arrays.asList(flowArr).forEach(o -> flowEnums.add(FlowEnum.valueOf(o)));
		System.out.println(flowEnums);
	}
}
