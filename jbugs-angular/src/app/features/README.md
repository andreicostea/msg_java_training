# Feature Modules

Put business components here. In general, high-level views ("pages") are top-level feature modules that are placed here. They implement domain and business concepts.

# What goes here

- top-level feature modules. Everything domain-related should be in a feature module.

# What goes in a feature module

Feature module contain the actual business views and domain logic. It has one or more components that it can tie together, and even export some if they're needed It'll usually have:

- routes, parametrised (e.g. /risks/:riskId;report=true)
- domain **models**, e.g. User - technically either an interface, or when needed, class
- services containing biz-logic - e.g. UserService, which can fetch a user profile, update email or description etc (using core Backend class in the background)
- **container** component - it'll usually define the layout of the current view (e.g. grid, place for a form, place for tables etc) and connects all the parts of the module
- **presentation** components (e.g. the actual form for showing or editing that user profile)
- **module** itself, which will define imports, exports, e.g. imports the shared module with styled buttons and exports the UserCard component etc
- a **README.md** file with a title, a one or two sentences of description and list of the things it deals with. If it exports services or components, it can shortly describe their API

# How to create a module

You can follow the guidelines in the kitchensink module.
