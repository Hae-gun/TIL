# HTML, CSS, Javascript 2020.01.09

### form, filedset, label

#### filedset

구역 박스 설정.

```html
<fieldset>
	<legend>관심분야?<small>(다수 선택 가능)</small></legend>
	<ul>
				
		<li><input type="checkbox" name="pre" value="grammer">문법</li>
		<li><input type="checkbox" name="pre" value="voca">어휘</li>
		<li><input type="checkbox" name="pre" value="listening">리스닝</li>
		<li><input type="checkbox" name="pre" value="speaking">회화</li>
				
	</ul>
</fieldset>
```

* legend : fieldset 제목.
* 결과

![image-20200109092832090](200109.assets/image-20200109092832090.png)

* 파일첨부 게시판 : enctype 꼭 필요! get type 사용불가 post사용

style 우선순위

선택자 style> head의 style> 외부 style

## Java script

class : 동작,기능

j query : class 묶음 라이브러리.

라이브러리 묶음 : 프레임워크.

Null : 값없음. undefined : 정의가 안됨.





document.getElementByid("id값").value -> id 가 "id값" 인 영역에서 value를 가져옴.