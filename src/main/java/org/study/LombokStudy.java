package org.study;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class LombokStudy {
    int number;
    public static void main(String[] args) {
        var ob = new LombokStudy();
        ob.setNumber(5);
        int i= ob.number;
        int iSet= ob.getNumber();
        System.out.println(i);
        System.out.println(iSet);

        Article a1 = Article.builder()
                .id(1L)
                .tag("TestTag1")
                .tag("TestTag2")
                .build();

        Article a2 = Article.builder()
                .id(2L)
                .title("Test Article")
                .tag("Demo")
                .build();

//Article(id=1, title=Test Article, tags=[Demo])
        System.out.println(a1);
        System.out.println(a2);

        Article.ArticleBuilder nearCopyBuilder1 = a1.toBuilder();
        Article.ArticleBuilder nearCopyBuilder2 = a2.toBuilder();

        System.out.println(nearCopyBuilder1);
        System.out.println(nearCopyBuilder2);

        Article b1 = nearCopyBuilder1.title("Final Title1").build();
        Article b2 = nearCopyBuilder2.title("Final Title2").build();
//Article(id=1, title=Final Title, tags=[Demo])

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(nearCopyBuilder1);
        System.out.println(nearCopyBuilder2);
    }

}

@Builder(toBuilder = true)
@Getter
@ToString
class Article {
    private Long id;

    @Builder.Default
    private String title = "Title Default";

    @Singular
    private List<String> tags;
}