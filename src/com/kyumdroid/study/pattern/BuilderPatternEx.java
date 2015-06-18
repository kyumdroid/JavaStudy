package com.kyumdroid.study.pattern;

/**
 *  설명 : 생성자의 멤버 변수가 많은 경우 필수 필드는 생성자의 매개 변수로 하고, 선택 필드는 setter 메소드로 값을 설정하고
 *         build 메소드로 객체를 생성하는 방식이다. 
 *  
 *  특징 : 각 매개 변수에 대해 명시적인 메소드가 존재하여 이해하기 쉽고, 순서에 상관없이 호출할 수 있다.
 *         멤버 필드의 기본 값을 미리 정의 하면, 더 편리하게 사용 가능하다.
 *
 */
public class BuilderPatternEx
{
    public static void main(String[] args)
    {
        final Book.Builder builder = new Book.Builder();
        final Book book = builder.setName("책이름").setType(BookType.ESSAY).build();
        
    }

}


enum BookType {FICTION, ESSAY, POEM}
class Book
{
    private final BookType type;
    private final String name;
    
    
    private Book(final BookType type, final String name)
    {
        this.type = type;
        this.name = name;
    }
    
    public static class Builder
    {
        private BookType type = BookType.FICTION;
        private String name;
        
        public Builder setType(BookType type)
        {
            this.type = type;
            return this;
        }
        
        public Builder setName(String name)
        {
            this.name = name;
            return this;
        }
        
        public Book build()
        {
//            if(name ==  null)
//            {
//                throw new IllegalStateException("Cannot create Book!! name is null. ");
//            }
            return new Book(type,name);
        }
        
    }
}