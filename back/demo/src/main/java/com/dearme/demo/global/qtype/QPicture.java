package com.dearme.demo.global.qtype;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.dearme.demo.domain.user.entity.Picture;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPicture is a Querydsl query type for Picture
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QPicture extends BeanPath<Picture> {

    private static final long serialVersionUID = -993753664L;

    public static final QPicture picture = new QPicture("picture");

    public final StringPath fileName = createString("fileName");

    public final StringPath realFileName = createString("realFileName");

    public QPicture(String variable) {
        super(Picture.class, forVariable(variable));
    }

    public QPicture(Path<? extends Picture> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPicture(PathMetadata metadata) {
        super(Picture.class, metadata);
    }

}

