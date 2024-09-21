The initial MVP version incorporates static layouts and views exclusively. Layouts serve to group views into clusters, each with distinct behaviors. The `Box` layout can function as a spacer element, analogous to those found in the Compose library.

### Config format
Configuration is represented as a JSON string.
Root properties
- **version** (int): Denotes the configuration version, which can be used for caching.
- **root** (object): Contains the descriptions of all layouts and views.

Example
```
{
  "version": 1,
  "root": {
     "type": "column",
     "enableScroll": true,
     "backgroundColor": "#cecece",
     "items": [
        {
          "type": "text",
          "text": "Test text"
        },
        {
           "type": "row",
           "items": [
             {
			   "type": "text",
			   "text": "Test text"
			 }
           ]
        }
     ]
   }
}

```

### Common properties

### Item type

Each item must include a `type` property, which specifies the item's type. The possible values for the `type` property are:
- column
- row
- box
- image
- text

### Padding

Padding for layouts or views can be configured using the `PaddingValues` object. It is important to note that all fields within the `PaddingValues` object are optional.

Example
```
{
  "top": 1,
  "bottom": 2,
  "start": 4,
  "end": 6
}
```

### Layouts
#### Column

The `Column` is a fundamental layout that can contain nested layouts. Nested layouts within a `Column` are arranged vertically, with the optional capability of vertical scrolling.

**Properties**
```
type - row
items: array of inner layouts
enableScroll: Boolean
backgroundColor: String (hex color)
borderWidth: Int
borderColor: String (hex color)
borderRadius: Int
padding: PaddingValues
```
#### Row

A fundamental layout that can house nested layouts. Nested layouts are arranged in a row, with the optional capability for horizontal scrolling.

**Properties**
```
type - column
items: array of inner layouts
enableScroll: Boolean
backgroundColor: String (hex color)
borderWidth: Int
borderColor: String (hex color)
borderRadius: Int
padding: PaddingValues
```
#### Box

A fundamental layout that can contain nested layouts. Nested layouts are arranged in a stack, one above the other. Alignment options are adjustable and include:

- TopStart (default)
- BottomStart
- TopEnd
- BottomEnd
- Center

**Properties**
```
type - box
items: array of inner layouts
contentAligment: Enum [TopStart,BottomStart,TopEnd,BottomEnd,Center]
backgraoundColor: String (hex color)
borderWidth: Int
borderColor: String (hex color)
borderRadius: Int
padding: PaddingValues
```

### Views

#### Text
Text view

**Properties**
```
type - text
text: String
fontWeight: Int
fontSize: Int
padding: PaddingValues
textColor: String (hex color)
backgroundColor: String (hex color)
textAlignment: Enum [start,end,center]
```

#### Image
Image view, support loading images by URL

**Properties**
```
type - image
url: String
scaleType: Enum [fit, crop, inside]
backgroundColor: String (hex color)
```

