<div align="center">
<h1>Kalah Implementation</h1>

<p>This is a Java RESTful Web Service that runs a game of 4-stone Kalah. This web service enables 2 human players to play the game, each in his own computer. There is no AI implemented.</p>

<p>This is a project </p>

<br />

[**Game Rules**](https://en.wikipedia.org/wiki/Kalah)
<br />
</div>

<hr />

<!-- prettier-ignore-start -->
[![MIT License][license-badge]][license]

<!-- prettier-ignore-end -->

## Table of Contents

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->

- [The problem](#the-problem)
- [The solution](#the-solution)
- [Installation](#installation)
  - [Suppressing unnecessary warnings on React DOM 16.8](#suppressing-unnecessary-warnings-on-react-dom-168)
- [Contributors](#contributors)
- [LICENSE](#license)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## The problem



You want to write maintainable tests for your React components. As a part of
this goal, you want your tests to avoid including implementation details of your
components and rather focus on making your tests give you the confidence for
which they are intended. As part of this, you want your testbase to be
maintainable in the long run so refactors of your components (changes to
implementation but not functionality) don't break your tests and slow you and
your team down.

## The solution

The `React Testing Library` is a very lightweight solution for testing React
components. It provides light utility functions on top of `react-dom` and
`react-dom/test-utils`, in a way that encourages better testing practices. Its
primary guiding principle is:

> [The more your tests resemble the way your software is used, the more
> confidence they can give you.][guiding-principle]

## Installation

This module is distributed via [npm][npm] which is bundled with [node][node] and
should be installed as one of your project's `devDependencies`:

```
npm install --save-dev @testing-library/react
```

or

for installation via [yarn][yarn]

```
yarn add --dev @testing-library/react
```

This library has `peerDependencies` listings for `react` and `react-dom`.

You may also be interested in installing `@testing-library/jest-dom` so you can
use [the custom jest matchers](https://github.com/testing-library/jest-dom).

> [**Docs**](https://testing-library.com/react)


## Contributors
Nathan Ribeiro
* [Github](https://github.com/nathanlogus)
* [LinkedIn](https://www.linkedin.com/in/nathanlogus/)

## LICENSE

[MIT](LICENSE)

<!-- prettier-ignore-start -->
[license-badge]: https://img.shields.io/npm/l/@testing-library/react.svg?style=flat-square
[license]: https://github.com/testing-library/react-testing-library/blob/main/LICENSE
<!-- prettier-ignore-end -->
