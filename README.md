# financial-IT-bootcamp

## 1. 해당 종목(삼성전자)의 테마 이름 
1. **해당종목의 테마 이름**

해당종목의 테마이름 조회

| URL | finbootcamp.com/stock/theme?code={종목명} |
| --- | --- |
| Content-Type | None |
| Request Method | GET |

**- Query String**

| **파라미터명** | **타입** | **필수여부** | **설명** |
| --- | --- | --- | --- |
| codeName | String | **Y** | 조회하고자하는 종목명 |
|
 |
 |
 |
 |
|
 |
 |
 |
 |

- **Response body**

| **엘리먼트**** 명 **|** 타입 **|** Depth **|** 배열 ****구분** | **설명** | **값 구분** |
| --- | --- | --- | --- | --- | --- |
| status | String | 1 | N | 응답 상태 코드 |
 |
| Result | String | 1 | N | 응답 상태에 대한 결과값 | Success : 성공(정상)Fail : 실패(오류) |
| description | String | 1 | N | 응답 결과에 대한 설명 |
 |
| theme | String | 1 | N | 요청된 종목코드 종목의 테마명 |
 |

- 샘플 JSON예제

|
- 실패할 경우 샘플{&quot;status&quot;: &quot;400&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;BAD REQUEST&quot;}{&quot;status&quot;: &quot;404&quot;, &quot;result&quot;:&quot;fail&quot;,&quot;description&quot;:&quot;NOT FOUND&quot;}

-성공할 경우 샘플{&quot;status&quot;: &quot;200&quot;, &quot;result&quot;: &quot;sucess&quot;, &quot;description&quot;: &quot;OK&quot;, &quot;theme&quot;: &quot;2차전지&quot;} |
| --- |






## 2. 코스피/코스닥 상위 5종목 시총 합

## 3. 코스피/코스닥 상위 30개 종목 코드 및 종목명

*디테일 정보 API 추가

## 4. 종목코드로 기업 종합 정보 조회

## 5. 코스닥 종목 중 가장 높은 ROE를 가진 종목의 정보

